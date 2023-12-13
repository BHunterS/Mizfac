package game;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Army implements Iterable<Warrior> {
    private static int idCounter = 0;
    private final int ID = ++idCounter;
    private Deque<WarriorInArmyImpl> troops = new ArrayDeque<>();
    private CanCommand warlord;

    public Army addUnits(WarriorClasses warriorClasses, int quantity) {
        return addUnits(warriorClasses::make, quantity);
    }

    public Army addUnits(Supplier<Warrior> warriorFactory, int count) {
        if (troops == null) troops = new ArrayDeque<>();
        for (int i = 0; i < count; i++) addUnit(warriorFactory.get());
        return this;
    }

    public void addUnit(Warrior warriorToAdd) {
        if(warriorToAdd instanceof CanCommand warlordToAdd) {
            if (warlord == null) warlord = warlordToAdd;
            else return;
        }

        var noviceInArmy = new WarriorInArmyImpl(warriorToAdd);
        Optional.ofNullable(troops.peekLast()).ifPresent(w -> w.setWarriorBehind(noviceInArmy));
        troops.add(noviceInArmy);
    }

    void removeDead() {
        troops.removeIf(w -> !w.isAlive());
    }

    public void moveUnits() {
        if(warlord == null) return;
        Collection<Warrior> newArmy = warlord.warlordCommand(troops.stream()
                .map(WarriorInArmyImpl::unwrap)
                .collect(Collectors.toList()));

        warlord = null;
        troops.clear();
        newArmy.forEach(this::addUnit);
    }

    public Deque<WarriorInArmyImpl> getArmy() {
        return troops;
    }

    interface Command {}

    interface ChampionDealsHit extends Command {
        ChampionDealsHit INSTANCE = new ChampionDealsHit(){};
    }

    private class WarriorInArmyImpl implements WarriorInArmy {
        private final Warrior warrior;
        private WarriorInArmy warriorBehind;

        public WarriorInArmyImpl(Warrior warrior) {
            this.warrior = Objects.requireNonNull(warrior);
        }

        public void setWarriorBehind(WarriorInArmy warriorBehind) {
            this.warriorBehind = Objects.requireNonNull(warriorBehind);
        }

        @Override
        public Optional<WarriorInArmy> getWarriorBehind() {
            return Optional.ofNullable(warriorBehind);
        }

        @Override
        public void acceptDamage(int damage) {
            warrior.acceptDamage(damage);
        }

        Warrior unwrap() {
            return warrior;
        }

        void passCommand(Command command, WarriorInArmy passer) {
            if(passer != this) {
                if(command instanceof ChampionDealsHit && warrior instanceof CanHeal healer) {
                    healer.heal(passer);
                }
            }

            getWarriorBehind().ifPresent(
                    w -> ((WarriorInArmyImpl) w).passCommand(
                            command, this));
        }

        @Override
        public void hit(CanAcceptDamage opponent) {
            warrior.hit(opponent);
            passCommand(ChampionDealsHit.INSTANCE, this);
        }

        @Override
        public int getAttack() {
            return warrior.getAttack();
        }

        @Override
        public int getHealth() {
            return warrior.getHealth();
        }

        @Override
        public boolean isAlive() {
            return warrior.isAlive();
        }

        @Override
        public String toString() {
            return warrior.toString();
        }

        @Override
        public void equipWeapon(Weapon weapon) {
            warrior.equipWeapon(weapon);
        }
    }

    @Override
    public Iterator<Warrior> iterator() {
        return AllAliveIterator();
    }

    public Iterator<Warrior> firstAliveIterator() {
        return new FirstAliveIterator();
    }

    public boolean isEmpty() {
        return !new FirstAliveIterator().hasNext();
    }

    private class FirstAliveIterator
        implements Iterator<Warrior> {

        @Override
        public boolean hasNext() {
            while(!troops.isEmpty() && !troops.peek().isAlive()) {
                troops.poll();
            }
            return !troops.isEmpty();
        }

        @Override
        public Warrior next() {
            if(!hasNext()) throw new NoSuchElementException();
            return troops.peek();
        }
    }

    private Iterator<Warrior> AllAliveIterator() {
        return troops.stream()
                .filter(Warrior::isAlive)
                .map(Army.WarriorInArmyImpl::unwrap)
                .iterator();
    }
}
