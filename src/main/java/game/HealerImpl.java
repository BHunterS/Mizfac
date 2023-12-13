package game;

public class HealerImpl extends AbstractWarrior implements CanHeal {
    private static final int INITIAL_HEALTH = 50;
    private static final int HEAL_POWER = 2;

    public HealerImpl() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return 0;
    }

    int getHealPower() {
        return Math.max(HEAL_POWER + getWeaponsHealPower(), 0);
    }

    private int getWeaponsHealPower() {
        int weaponsHealPower = 0;
        for(Weapon weapon : weapons) weaponsHealPower += weapon.healPower;
        return weaponsHealPower;
    }

    @Override
    public void heal(HasHealth patient) {
        if(patient instanceof AbstractWarrior abstractWarrior) {
            abstractWarrior.setHealth(abstractWarrior.getHealth() + getHealPower());
        }
    }
}
