package nl.duckson.zombiesiege.weapon;

import nl.duckson.zombiesiege.Game;
import nl.duckson.zombiesiege.bullet.Bullet;

/**
 * The Minigun!
 * User: mathijs
 * Date: 30/09/2013
 */
public class Minigun extends Weapon {
    private static int getBulletCountForRound() {
        return (int) Math.round(Math.random() * 10);
    }

    private static int randomXForDirection(int direction) {
        return direction;
    }

    private static int randomYForDirection(int direction) {
        return direction;
    }

    public Bullet[] fire(int x, int y, int direction) {
        if(isOutOfAmmunition()) {
            System.out.println("Your " + getName() + " is out of ammo!");
            return new Bullet[0];
        }

        Bullet b = new Bullet(x, y, direction);
        Bullet[] bs = { b };

        ammunition -= bs.length;

        return bs;
    }

//    public Bullet[] fire(int x, int y, int direction) {
//        int bullet_count = 8;
//        int bx = x, by = y;
////        int bullet_count = getBulletCountForRound();
////
////        if(bullet_count > remainingAmmunition()) {
////            bullet_count = remainingAmmunition();
////        }
//        Bullet[] bullets = new Bullet[bullet_count];
//
//        for(int i = 0; i < bullets.length; i++) {
//            bx += (int) (Math.random() * 8);
//            Bullet b = new Bullet(bx, by, direction);
//            bullets[i] = b;
//        }
//
//        return bullets;
//    }

    public int maximumAmmunition() {
        return 500;
    }

    public boolean isAutomatic() {
        return true;
    }

    public String getName() {
        return "Minigun";
    }

    // Sounds
    public void playStartFiringSound() {
        Game.playSound("weapon/minigun/minigun_start.wav");
    }
    public void playFireSound() {
        Game.playSound("weapon/minigun/minigun_fire.wav");
    }
}
