package game;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WarlordImpl extends AbstractWarrior implements CanCommand, HasDefence {
    private static final int ATTACK = 4;
    private static final int INITIAL_HEALTH = 100;
    private static final int DEFENSE = 2;

    public WarlordImpl() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getDefence() {
        return Math.max(DEFENSE + getWeaponsDefense(), 0);
    }

    @Override
    public void acceptDamage(int damage) {
        int reducedDamage = Math.max(0, damage - getDefence());
        super.acceptDamage(reducedDamage);
    }

    private int getWeaponsDefense() {
        int weaponsDefense = 0;
        for(Weapon weapon : weapons) weaponsDefense += weapon.defense;
        return weaponsDefense;
    }

    @Override
    public Collection<Warrior> warlordCommand(Collection<Warrior> army) {
        ArrayList<Warrior> organizedList = new ArrayList<>();
        List<Warrior> lancers = filterWarriorsByType(army, LancerImpl.class);
        List<Warrior> otherWarriors = filterWarriorsByType(army, warrior -> !(warrior instanceof LancerImpl));

        lancers.removeIf(warrior -> !warrior.isAlive());

        Warrior firstPosition = null, secondPosition = null, warlord = null;

        for (Warrior warrior : lancers) {
            if(firstPosition != null && secondPosition != null && warlord != null) break;
            if(warrior == null) continue;

            if (warrior instanceof HealerImpl) {
                if (secondPosition == null) secondPosition = warrior;
            } else if (warrior instanceof WarlordImpl && warlord == null) {
                warlord = warrior;
            } else if (firstPosition == null) {
                firstPosition = warrior;
            }
        }

        organizedList.add(firstPosition);
        organizedList.add(secondPosition);
        organizedList.add(warlord);

        organizedList.removeAll(Arrays.asList(null, null, null)); // Remove null elements

        return organizedList;
    }

    private List<Warrior> filterWarriorsByType(Collection<Warrior> warriors, Class<? extends Warrior> type) {
        return warriors.stream()
                .filter(type::isInstance)
                .collect(Collectors.toList());
    }

    private List<Warrior> filterWarriorsByType(Collection<Warrior> warriors, Predicate<Warrior> condition) {
        return warriors.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
}
