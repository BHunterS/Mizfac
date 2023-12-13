package game;

public interface CanHit extends HasAttack {
    default void hit(CanAcceptDamage opponent) {
        opponent.acceptDamage(getAttack());
    }
}
