package nl.duckson.zombiesiege.weapon;

import nl.duckson.zombiesiege.bullet.Bullet;
import nl.duckson.zombiesiege.entity.Player;

/**
 * Abstract weapon class
 * User: mathijs
 * Date: 30/09/2013
 */
abstract public class Weapon implements Weaponable {
    public int ammunition = 0;
    private String name;

    public Weapon() {
        this.reload();
    }

    public Bullet[] fire(int x, int y, int direction) {
        Bullet b = new Bullet(x, y, direction);
        Bullet[] bs = { b };

        return bs;
    }

    public String getName() {
        return this.getClass().toString();
    }

    public int remainingAmmunition() {
        return ammunition;
    }

    public boolean isOutOfAmmunition() {
        return ammunition == 0;
    }

    public boolean isAutomatic() {
        return false;
    }

    public boolean reload() {
        this.ammunition = maximumAmmunition();
        return true;
    }

    public Bullet newBullet() {
        return new Bullet();
    }
    public Bullet newBullet(int x, int y, int direction) {
        return new Bullet(x, y, direction);
    }

    public void playStartFiringSound() {};
    public void playStopFiringSound() {};
    public void playFireSound() {};
    public void playEmptyFireSound() {};
    public void playReloadSound() {};
}
