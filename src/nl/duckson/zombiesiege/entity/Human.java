package nl.duckson.zombiesiege.entity;

import java.awt.geom.AffineTransform;

public class Human extends Entity implements Directionable, Attackable {
    protected static int width = 64, height = 64;

    /**
     * The direction in degrees the entity is facing
     */
    protected int direction = 0;

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
        return hitpoints >= 0;
    }

    public void watch(int x, int y) {
        // Bereken de hoek om naar te kijken...
        int delta_x = this.x - x;
        int delta_y = this.y - y;

        // @todo: This calculation is terrible, refactor it!
        direction = (int) Math.toDegrees(
                Math.atan2(delta_y, delta_x)
        );

        // @todo: Find out what this offset is about
        direction -= (90 + 45);
    }

    public AffineTransform getAffineTransform() {
        AffineTransform trans = new AffineTransform();
        trans.translate(x, y);
        trans.rotate(Math.toRadians(direction), width / 2, height / 2);

        return trans;
    }

    public int getDirectionDegrees() {
        return direction;
    }

    public double getDirectionRadians() {
        return Math.toRadians(direction);
    }

    public String getIcon() {
        return "human.png";
    }
}
