package game;

public class KnightImpl extends AbstractWarrior {
    static final int INITIAL_HEALTH = 50;
    public static final int ATTACK = 7;

    public KnightImpl() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() { return ATTACK; }
}
