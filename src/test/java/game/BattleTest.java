package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static game.WarriorClasses.*;
import static org.junit.jupiter.api.Assertions.*;

public class BattleTest {

    @Test
    @DisplayName("Army(1 Warrior) VS Army(2 Warriors)")
    void battle1() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(WARRIOR, 1);
        army2.addUnits(WARRIOR, 2);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(2 Warrior) VS Army(3 Warriors)")
    void battle2() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(WARRIOR, 2);
        army2.addUnits(WARRIOR, 3);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(5 Warrior) VS Army(7 Warriors)")
    void battle3() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(WARRIOR, 5);
        army2.addUnits(WARRIOR, 7);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(20 Warrior) VS Army(21 Warriors)")
    void battle4() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(WARRIOR, 20);
        army2.addUnits(WARRIOR, 21);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(10 Warrior) VS Army(11 Warriors)")
    void battle5() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(WARRIOR, 10);
        army2.addUnits(WARRIOR, 11);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(11 Warrior) VS Army(7 Warriors)")
    void battle6() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(WARRIOR, 11);
        army2.addUnits(WARRIOR, 7);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(5 Warrior and 4 Defender) VS Army(5 Defender and 4 Warriors)")
    void battle7() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(WARRIOR, 5);
        army1.addUnits(DEFENDER, 4);
        army2.addUnits(WARRIOR, 5);
        army2.addUnits(DEFENDER, 4);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(5 Defender and 20 Warriors) VS Army(21 Warriors and 4 Defender)")
    void battle8() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(DEFENDER, 5);
        army1.addUnits(WARRIOR, 20);
        army2.addUnits(WARRIOR, 21);
        army2.addUnits(DEFENDER, 4);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(10 Warriors and 5 Defender) VS Army(5 Warriors and 10 Defender)")
    void battle9() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(WARRIOR, 10);
        army1.addUnits(DEFENDER, 5);
        army2.addUnits(WARRIOR, 5);
        army1.addUnits(DEFENDER, 10);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(2 Defender and 1 Warriors) VS Army(1 Defender and 5 Warriors)")
    void battle10() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(DEFENDER, 2);
        army1.addUnits(WARRIOR, 1);
        army2.addUnits(WARRIOR, 1);
        army2.addUnits(DEFENDER, 5);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(5 Defender, 6 Vampires and  7 Warriors) VS Army(6 Warriors, 6 Defender and 6 Vampires)")
    void battle11() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(DEFENDER, 5);
        army1.addUnits(VAMPIRE, 6);
        army1.addUnits(WARRIOR, 7);
        army2.addUnits(WARRIOR, 6);
        army2.addUnits(DEFENDER, 6);
        army2.addUnits(VAMPIRE, 6);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(2 Defender, 3 Vampires and  4 Warriors) VS Army(4 Warriors, 4 Defender and 3 Vampires)")
    void battle12() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(DEFENDER, 2);
        army1.addUnits(VAMPIRE, 3);
        army1.addUnits(WARRIOR, 4);
        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 4);
        army2.addUnits(VAMPIRE, 3);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(11 Defender, 3 Vampires and  4 Warriors) VS Army(4 Warriors, 4 Defender and 13 Vampires)")
    void battle13() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(DEFENDER, 11);
        army1.addUnits(VAMPIRE, 3);
        army1.addUnits(WARRIOR, 4);
        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 4);
        army2.addUnits(VAMPIRE, 13);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(9 Defender, 3 Vampires and  8 Warriors) VS Army(4 Warriors, 4 Defender and 13 Vampires)")
    void battle14() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(DEFENDER, 9);
        army1.addUnits(VAMPIRE, 3);
        army1.addUnits(WARRIOR, 8);
        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 4);
        army2.addUnits(VAMPIRE, 13);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(5 Lancer, 3 Vampires, 4 Warriors and 2 Defender) VS Army(4 Warriors, 4 Defender, 6 Vampires and 5 Lancer)")
    void battle15() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(LANCER, 5);
        army1.addUnits(VAMPIRE, 3);
        army1.addUnits(WARRIOR, 4);
        army1.addUnits(DEFENDER, 2);
        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 4);
        army2.addUnits(VAMPIRE, 6);
        army2.addUnits(LANCER, 5);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(7 Lancer, 3 Vampires, 4 Warriors and 2 Defender) VS Army(4 Warriors, 4 Defender, 6 Vampires and 4 Lancer)")
    void battle16() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(LANCER, 7);
        army1.addUnits(VAMPIRE, 3);
        army1.addUnits(WARRIOR, 4);
        army1.addUnits(DEFENDER, 2);
        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 4);
        army2.addUnits(VAMPIRE, 6);
        army2.addUnits(LANCER, 4);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(7 Lancer, 3 Vampires, 4 Warriors and 2 Defender) VS Army(4 Warriors, 4 Defender, 6 Vampires and 4 Lancer)")
    void battle17() {
        var army_warrior = new Army();
        var army_lancer = new Army();

        army_warrior.addUnits(WARRIOR, 2);
        army_lancer.addUnits(LANCER, 1);
        army_lancer.addUnits(WARRIOR, 1);

        var res = Game.fight(army_warrior, army_lancer);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(1 Lancer, 8 Warriors, 2 Healer and 2 Knight) VS Army(4 Warriors, 4 Defender, 1 Healer, 6 Vampires and 4 Lancer)")
    void battle18() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(LANCER, 1);
        army1.addUnits(WARRIOR, 3);
        army1.addUnits(HEALER, 1);
        army1.addUnits(WARRIOR, 4);
        army1.addUnits(HEALER, 1);
        army1.addUnits(KNIGHT, 2);

        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 4);
        army2.addUnits(HEALER, 1);
        army2.addUnits(VAMPIRE, 6);
        army2.addUnits(LANCER, 4);

        var res = Game.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(7 Lancer, 3 Vampires, 4 Warriors and 2 Defender) VS Army(4 Warriors, 6 Defender, 6 Vampires and 5 Lancer)")
    void battle19() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(LANCER, 5);
        army1.addUnits(VAMPIRE, 3);
        army1.addUnits(WARRIOR, 4);
        army1.addUnits(DEFENDER, 2);

        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 6);
        army2.addUnits(VAMPIRE, 6);
        army2.addUnits(LANCER, 5);

        var res = Game.straightFight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(7 Lancer, 3 Vampires, 4 Warriors and 2 Defender) VS Army(4 Warriors, 4 Defender, 6 Vampires and 4 Lancer)")
    void battle20() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(LANCER, 7);
        army1.addUnits(VAMPIRE, 3);
        army1.addUnits(WARRIOR, 4);
        army1.addUnits(DEFENDER, 2);

        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 4);
        army2.addUnits(VAMPIRE, 6);
        army2.addUnits(LANCER, 4);

        var res = Game.straightFight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(7 Lancer, 3 Vampire, 4 Warrior, 2 Healer and 2 Defender) VS Army(4 Warriors, 4 Defender, 1 Healer, 6 Vampires and 4 Lancer)")
    void battle21() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(LANCER, 7);
        army1.addUnits(VAMPIRE, 3);
        army1.addUnits(HEALER, 1);
        army1.addUnits(WARRIOR, 4);
        army1.addUnits(HEALER, 1);
        army1.addUnits(DEFENDER, 2);

        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 4);
        army2.addUnits(HEALER, 1);
        army2.addUnits(VAMPIRE, 6);
        army2.addUnits(LANCER, 4);

        var res = Game.straightFight(army1, army2);

        assertFalse(res);
    }

    @Test
    @DisplayName("Army(4 Lancer, 7 Warrior, 2 Healer and 2 Knight) VS Army(4 Warriors, 4 Defender, 1 Healer, 2 Vampires and 4 Lancer)")
    void battle22() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(LANCER, 4);
        army1.addUnits(WARRIOR, 3);
        army1.addUnits(HEALER, 1);
        army1.addUnits(WARRIOR, 4);
        army1.addUnits(HEALER, 1);
        army1.addUnits(KNIGHT, 2);

        army2.addUnits(WARRIOR, 4);
        army2.addUnits(DEFENDER, 4);
        army2.addUnits(HEALER, 1);
        army2.addUnits(VAMPIRE, 2);
        army2.addUnits(LANCER, 4);

        var res = Game.straightFight(army1, army2);

        assertTrue(res);
    }

    @Test
    @DisplayName("Army(11 Warrior and 5 Knights) VS Army(7 Warriors and 8 Knights)")
    void battleWithKnights() {
        var army1 = new Army();
        var army2 = new Army();

        army1.addUnits(WARRIOR, 11).addUnits(KNIGHT, 5);
        army2.addUnits(WARRIOR, 7).addUnits(KNIGHT, 8);

        var res = Game.fight(army1, army2);

        assertTrue(res);
    }
}
