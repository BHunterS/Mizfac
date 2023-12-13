package game;

public class DefenderImpl extends AbstractWarrior implements HasDefence {
    static final int INITIAL_HEALTH = 60;
    static final int ATTACK = 3;
    static final int DEFENSE = 2;

    public DefenderImpl() { super(INITIAL_HEALTH); }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public int getDefence() { return Math.max(DEFENSE + getWeaponsDefense(), 0); }

    private int getWeaponsDefense() {
        int weaponsDefense = 0;
        for(Weapon weapon : weapons) weaponsDefense += weapon.defense;
        return weaponsDefense;
    }

    @Override
    public void acceptDamage(final int damage) {
        int reducedDamage = Math.max(0, damage - getDefence());
        super.acceptDamage(reducedDamage);
    }
}
