package nl.duckson.zombiesiege.entity;

import java.awt.geom.AffineTransform;

public interface Directionable {

    /**
     * Tell the Entity to look at a certain coordinate
     * @param x int
     * @param y int
     * @return void
     */
    public void watch(int x, int y);

    /**
     * Get an Affine transform according to the current direction
     * @return AffineTransform
     */
    public AffineTransform getAffineTransform();

    /**
     * Get the current direction in degrees (0 to 360)
     * @return int
     */
    public int getDirectionDegrees();

    /**
     * Get the current direcition in radians
     * @return double
     */
    public double getDirectionRadians();
}
