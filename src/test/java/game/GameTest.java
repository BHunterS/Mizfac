package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static game.Game.fight;
import static game.WarriorClasses.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    /* Warrior and Knights */
    @Test
    @DisplayName("1. Fight: 1 Warrior VS 1 Knight")
    void fight1() {
        Warrior carl = WARRIOR.make();
        Warrior jim = KNIGHT.make();

        boolean expected = false;
        boolean res = fight(carl, jim);

        assertEquals(expected, res);
    }

    @Test
    @DisplayName("2. Fight: 1 Knight VS 1 Warrior")
    void fight2() {
        Warrior ramon = KNIGHT.make();
        Warrior slevin = WARRIOR.make();

        boolean expected = true;
        boolean res = fight(ramon, slevin);

        assertEquals(expected, res);
    }

    @Test
    @DisplayName("3. Fight: 1 Warrior VS 1 Warrior")
    void fight3() {
        Warrior bob = WARRIOR.make();
        Warrior mars = WARRIOR.make();

        boolean expected = true;
        fight(bob, mars);
        boolean res = bob.isAlive();

        assertEquals(expected, res);
    }

    @Test
    @DisplayName("4. Fight: 1 Knight VS 1 Warrior")
    void fight4() {
        Warrior zeus = KNIGHT.make();
        Warrior godkiller = WARRIOR.make();

        boolean expected = true;
        fight(zeus, godkiller);
        boolean res = zeus.isAlive();

        assertEquals(expected, res);
    }

    @Test
    @DisplayName("5. Fight: 1 Warrior VS 1 Warrior")
    void fight5() {
        Warrior husband = WARRIOR.make();
        Warrior wife = WARRIOR.make();

        boolean expected = false;
        fight(husband, wife);
        boolean res = wife.isAlive();

        assertEquals(expected, res);
    }

    @Test
    @DisplayName("6. Fight: 1 Warrior VS 1 Knight")
    void fight6() {
        Warrior dragon = WARRIOR.make();
        Warrior knight = KNIGHT.make();

        boolean expected = true;
        fight(dragon, knight);
        boolean res = knight.isAlive();

        assertEquals(expected, res);
    }

    @Test
    @DisplayName("7. Fight: 1 Warrior VS 1 Knight and then 1 Knight VS Warrior")
    void fight7() {
        Warrior unit_1 = WARRIOR.make();
        Warrior unit_2 = KNIGHT.make();
        Warrior unit_3 = WARRIOR.make();

        fight(unit_1, unit_2);

        boolean res = fight(unit_2, unit_3);

        assertFalse(res);
    }
}
