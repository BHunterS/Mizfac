package game;

public class VampireImpl extends AbstractWarrior implements HasVampirism, CanHitAndReportMixin {
    static final int ATTACK = 4;
    static final int INITIAL_HEALTH = 40;
    static final int VAMPIRISM = 50;

    public VampireImpl() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    private int getWeaponsVampirism() {
        int weaponsVampirism = 0;

        for (Weapon weapon : weapons) weaponsVampirism += weapon.vampirism;

        return weaponsVampirism;
    }

    @Override
    public int getVampirism() {
        return Math.max(VAMPIRISM + getWeaponsVampirism(), 0);
    }

    @Override
    public void hit(CanAcceptDamage opponent) {
        var damageDealt = hitAndReportDealtDamage(opponent);
        var healing = damageDealt * getVampirism() / 100;
        setHealth(getHealth() + healing);
    }

    @Override
    public int hitAndReportDealtDamage(CanAcceptDamage opponent) {
        int healthBefore = opponent.getHealth();
        opponent.acceptDamage(getAttack() + getWeaponsAttack());
        int healthAfter = opponent.getHealth();
        return healthBefore - healthAfter;
    }
}

