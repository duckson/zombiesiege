package nl.duckson.zombiesiege.entity;

public interface Attackable {
    /**
     * Attack an enemy and give them a hit.
     * This function needs to calculate how many hitpoints the attack will yield.
     * @param enemy
     */
    public int hit(Attackable enemy);
}