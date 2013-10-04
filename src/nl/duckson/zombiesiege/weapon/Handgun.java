package nl.duckson.zombiesiege.weapon;

import nl.duckson.zombiesiege.bullet.Bullet;

public class Handgun extends Weapon implements Weaponable {
    public Bullet[] fire(int x, int y, int direction) {
        if(isOutOfAmmunition()) {
            System.out.println("Your " + getName() + " is out of ammo!");
            return new Bullet[0];
        }

        Bullet[] bullets = new Bullet[1];
        bullets[0] = newBullet(x, y, direction);

        ammunition--;

        return bullets;
    }

    @Override
    public String getName() {
        return "Proppenschieter";
    }

    @Override
    public int maximumAmmunition() {
        return 6;
    }
}
