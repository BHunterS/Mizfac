package game;

public interface CanHitAndReportMixin extends CanHit {
    default int hitAndReportDealtDamage(CanAcceptDamage opponent) {
        var healthBefore = opponent.getHealth();
        CanHit.super.hit(opponent);
        var healthAfter = opponent.getHealth();
        return healthBefore - healthAfter;
    }
}
