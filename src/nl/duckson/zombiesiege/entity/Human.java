package nl.duckson.zombiesiege.entity;

public class Human extends Directionable implements Attackable {
    protected static int width = 64, height = 64;

    public Human() {
        this.hitpoints = startHitpoints();
    }

    public int hit(Attackable enemy) {
        return 0;
    }

    protected int hitpoints = 0;

    public int startHitpoints() {
        return 10;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public boolean isDead() {
        return hitpoints == 0;
    }

    public String getIcon() {
        return "human.png";
    }
}
