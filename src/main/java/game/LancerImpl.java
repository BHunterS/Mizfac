package game;

public class LancerImpl extends AbstractWarrior implements CanHitAndReportMixin {
    static final int ATTACK = 6;
    static final int INITIAL_HEALTH = 50;
    static final int PENETRATION = 50;

    public LancerImpl() {
        super(INITIAL_HEALTH);
    }

    public int getPenetration() {
        return PENETRATION;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void hit(CanAcceptDamage opponent) {
        var damageDealt = hitAndReportDealtDamage(opponent);
        if(opponent instanceof WarriorInArmy warriorInArmy) {
            var nextBehind = warriorInArmy.getWarriorBehind();
            if(nextBehind.isPresent()) {
                int secondDamage = damageDealt * getPenetration() / 100;
                CanHit proxySecondHitByLancer = () -> secondDamage + getWeaponsAttack();
                proxySecondHitByLancer.hit(nextBehind.get());
            }
        }
    }

    @Override
    public int hitAndReportDealtDamage(CanAcceptDamage opponent) {
        int healthBefore = opponent.getHealth();
        opponent.acceptDamage(getAttack() + getWeaponsAttack());
        int healthAfter = opponent.getHealth();
        return healthBefore - healthAfter;
    }
}
