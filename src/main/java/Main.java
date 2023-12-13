import game.Warrior;
import game.Weapon;

import static game.Game.fight;
import static game.WarriorClasses.*;
import static game.WarriorClasses.LANCER;
import static game.WeaponClasses.GREAT_AXE;
import static game.WeaponClasses.SHIELD;

public class Main {
    public static void main(String[] args) {
        Warrior unit1 = DEFENDER.make();
        Warrior unit2 = LANCER.make();
        Weapon weapon1 = SHIELD.make();
        Weapon weapon2 = GREAT_AXE.make();
        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);

        var res = fight(unit1, unit2);
        System.out.println(res);
    }
}