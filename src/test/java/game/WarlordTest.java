package game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static game.Game.fight;
import static game.WarriorClasses.*;
import static game.WeaponClasses.*;
import static org.junit.jupiter.api.Assertions.*;

public class WarlordTest {

    @Test
    @DisplayName("1. Warlord")
    void fight1() {
        Warrior unit1 = WarriorClasses.factory(DEFENDER);
        Warrior unit2 = WarriorClasses.factory(WARLORD);

        var res = fight(unit1, unit2);
        assertFalse(res);
    }

    @Test
    @DisplayName("2. Warlord")
    void fight2() {
        Warrior unit1 = WarriorClasses.factory(WARLORD);
        Warrior unit2 = WarriorClasses.factory(VAMPIRE);

        var res = fight(unit1, unit2);
        assertTrue(res);
    }

    @Test
    @DisplayName("3. Warlord")
    void fight3() {
        Warrior unit1 = WarriorClasses.factory(WARLORD);
        Warrior unit2 = WarriorClasses.factory(KNIGHT);

        var res = fight(unit1, unit2);
        assertTrue(res);
    }

    @Test
    @DisplayName("3. Warlord")
    void battle1() {
        Army army1 = new Army()
                .addUnits(WARLORD, 1)
                .addUnits(WARRIOR, 2)
                .addUnits(LANCER, 2)
                .addUnits(HEALER, 2);

        Army army2 = new Army()
                .addUnits(WARLORD, 1)
                .addUnits(VAMPIRE, 1)
                .addUnits(HEALER, 2)
                .addUnits(KNIGHT, 2);

        army1.moveUnits();
        army2.moveUnits();

        var res = fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("24. Warlord")
    void battle2() {
        Army army1 = new Army()
                .addUnits(WARRIOR, 2)
                .addUnits(LANCER, 2)
                .addUnits(DEFENDER, 1)
                .addUnits(WARLORD, 3);

        Army army2 = new Army()
                .addUnits(WARLORD, 2)
                .addUnits(VAMPIRE, 1)
                .addUnits(HEALER, 5)
                .addUnits(KNIGHT, 2);

        army1.moveUnits();
        army2.moveUnits();

        var res = fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("25. Warlord")
    void battle3() {
        Army army1 = new Army()
                .addUnits(WARRIOR, 2)
                .addUnits(LANCER, 3)
                .addUnits(DEFENDER, 1)
                .addUnits(WARLORD, 4);

        Army army2 = new Army()
                .addUnits(WARLORD, 1)
                .addUnits(VAMPIRE, 1)
                .addUnits(ROOKIE, 1)
                .addUnits(KNIGHT, 1);

        List<Warrior> list1 = new ArrayList<>(army1.getArmy());
        List<Warrior> list2 = new ArrayList<>(army2.getArmy());

        list1.get(0).equipWeapon(WeaponClasses.factory(SWORD));
        list2.get(0).equipWeapon(WeaponClasses.factory(SHIELD));

        army1.moveUnits();
        army2.moveUnits();

        var res = fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("26. Warlord")
    void battle4() {
        Army army1 = new Army()
                .addUnits(WARRIOR, 2)
                .addUnits(LANCER, 3)
                .addUnits(DEFENDER, 1)
                .addUnits(WARLORD, 1);

        Army army2 = new Army()
                .addUnits(WARLORD, 5)
                .addUnits(VAMPIRE, 1)
                .addUnits(ROOKIE, 1)
                .addUnits(KNIGHT, 1);

        List<Warrior> list1 = new ArrayList<>(army1.getArmy());
        List<Warrior> list2 = new ArrayList<>(army2.getArmy());

        list1.get(0).equipWeapon(WeaponClasses.factory(SWORD));
        list2.get(0).equipWeapon(WeaponClasses.factory(SHIELD));

        army1.moveUnits();
        army2.moveUnits();

        var res = fight(army1, army2);
        assertTrue(res);
    }
}