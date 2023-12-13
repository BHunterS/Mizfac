package game;

public enum WeaponClasses {
    SWORD, SHIELD, GREAT_AXE, KATANA, MAGIC_WAND;

    public static Weapon factory(WeaponClasses weaponClasses) {
        return switch (weaponClasses) {
            case SWORD -> new Weapon(5, 2, 0, 0, 0);
            case SHIELD -> new Weapon(20, -1, 2, 0, 0);
            case GREAT_AXE -> new Weapon(-15, 5, -2, 10, 0);
            case KATANA -> new Weapon(-20, 6, -5, 50, 0);
            case MAGIC_WAND -> new Weapon(30, 3, 0, 0, 3);
        };
    }

    public Weapon make() {
        return factory(this);
    }
}
