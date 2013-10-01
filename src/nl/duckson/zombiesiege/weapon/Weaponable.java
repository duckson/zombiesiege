package nl.duckson.zombiesiege.weapon;

import nl.duckson.zombiesiege.bullet.Bullet;

public interface Weaponable {
    /**
     * Fire the weapon, return the set of bullets it fired
     * in this round.
     * @return Bullet[]
     */
    public Bullet[] fire(int x, int y, int direction);

    public int maximumAmmunition();

    /**
     * Get the remaining ammo.
     * @return int
     */
    public int remainingAmmunition();

    /**
     * Get the weapon's name
     * @return string
     */
    public String getName();

    /**
     * Whether or not the weapon supports automatic firing
     * @return boolean
     */
    public boolean isAutomatic();

    /**
     * Reload the weapon if applicable
     * @return boolean
     */
    public boolean reload();
}