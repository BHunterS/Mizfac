package game;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public abstract class AbstractWarrior implements Warrior {
    private static int idCounter = 0;
    private final int ID = ++idCounter;
    private int health;
    private int initialHealth;
    protected ArrayList<Weapon> weapons = new ArrayList<>();

    public AbstractWarrior(int health) {
        this.health = health;
        this.initialHealth = health;
    }

    @Override
    public void hit(CanAcceptDamage opponent) {
        log.info("Warrior {} hits {}", this, opponent);
        opponent.acceptDamage(getAttack() + getWeaponsAttack());
    }

    public void acceptDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    public abstract int getAttack();

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = Math.min(health, initialHealth);
    }

    public void equipWeapon(Weapon weapon) {
        weapons.add(weapon);
        int weaponHealth = weapon.health;
        initialHealth += weaponHealth;
        health += weaponHealth;
    }

    protected int getWeaponsAttack() {
        int weaponsAttack = 0;

        for(Weapon weapon : weapons) weaponsAttack += weapon.attack;

        return weaponsAttack;
    }

    @Override
    public String toString() {
        String name = getClass().getSimpleName();
        name.replaceAll("Impl", "");
        name = name.toUpperCase();

        return name + " " + ID + "{h=" + health + ", a=" + getAttack() + "}";
    }
}
