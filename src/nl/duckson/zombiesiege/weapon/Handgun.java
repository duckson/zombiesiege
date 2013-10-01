package nl.duckson.zombiesiege.weapon;

import nl.duckson.zombiesiege.bullet.Bullet;

public class Handgun extends Weapon implements Weaponable {
    private final int BULLET_SPEED = 4;

    public Bullet[] fire(int x, int y, int direction) {
        Bullet[] bullets = new Bullet[1];

        if(remainingAmmunition() == 0) {
            System.out.println("Your " + getName() + " is out of ammo!");
            return null;
        }

        bullets[0] = new Bullet(x, y, direction);
        ammunition--;

        return bullets;
    }

    public String getName() {
        return "Handgun";
    }

    public int maximumAmmunition() {
        return 6;
    }
}
