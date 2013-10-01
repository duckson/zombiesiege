package nl.duckson.zombiesiege.entity;

import java.awt.geom.AffineTransform;

abstract public class Directionable extends Entity {
    /**
     * The direction in degrees the entity is facing
     */
    protected int direction = 0;

    public int watch(int x, int y) {
        // Bereken de hoek om naar te kijken...
        int delta_x = this.x - x;
        int delta_y = this.y - y;

        direction = (int) Math.toDegrees(
                Math.atan2(delta_y, delta_x)
        );

        // @todo: Find out what this offset is about
        direction -= (90 + 45);
        return direction;
    }

    public AffineTransform getAffineTransform() {
        AffineTransform trans = new AffineTransform();
        trans.translate(x, y);
        trans.rotate(Math.toRadians(direction), width / 2, height / 2);

        return trans;
    }
}
