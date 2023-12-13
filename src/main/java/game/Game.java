package game;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

@Slf4j
public class Game {
    public static boolean fight(Warrior first, Warrior second) {
        while(first.isAlive()) {
            first.hit(second);
            System.out.println(first.getHealth() + " " + second.getHealth());

            if (!second.isAlive()) {
                return true;
            }
            second.hit(first);
        }
        return false;
    }

    public static boolean fight(Army first, Army second) {
        log.info("Army {} fights against Army {}", first, second);
        Iterator<Warrior> iterator1 = first.firstAliveIterator();
        Iterator<Warrior> iterator2 = second.firstAliveIterator();

        while(iterator1.hasNext() && iterator2.hasNext()) {
            fight(iterator1.next(), iterator2.next());
        }

        return iterator1.hasNext();
    }

    public static boolean straightFight(Army first, Army second) {
        log.info("Army {} fights against Army {}", first, second);

        while(!first.isEmpty() && !second.isEmpty()) {
            Iterator<Warrior> iterator1 = first.iterator();
            Iterator<Warrior> iterator2 = second.iterator();

            while(iterator1.hasNext() && iterator2.hasNext()) {
                fight(iterator1.next(), iterator2.next());
            }
        }

        return !first.isEmpty();
    }
}
