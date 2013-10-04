package nl.duckson.zombiesiege.weapon;

import nl.duckson.zombiesiege.Game;
import nl.duckson.zombiesiege.bullet.*;

/**
 * Shoots a bunch of scattered projectiles
 */
public class Shotgun extends Weapon implements Weaponable {
    private static int bullets_per_shot = 4;

    public Bullet[] fire(int x, int y, int direction) {
        if(isOutOfAmmunition()) {
            System.out.println("Your " + getName() + " is out of ammo!");
            return new Bullet[0];
        }

        Bullet[] bullets = new Bullet[bullets_per_shot];

        for(int i = 0; i < bullets.length; i++) {
            int bx, by;
            bx = x + (int) Math.round((Math.random() * 40));
            by = y + (int) Math.round(Math.random() * 10);

            Bullet b = new HailRound(bx, by, direction);
            bullets[i] = b;
        }

        ammunition--;

        return bullets;
    }

    @Override
    public String getName() {
        return "Shotgun";
    }

    @Override
    public int maximumAmmunition() {
        return 1;
    }

    // Sounds
    public void playFireSound() {
        Game.playSound("weapon/shotgun/shotgun_fire.wav");
    }
}
