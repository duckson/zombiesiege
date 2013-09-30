package nl.duckson.zombiesiege.entity;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/**
 * User: mathijs
 * Date: 23/09/2013
 * Time: 17:21
 */
public class Player extends Entity {
    public ArrayList<Bullet> bullets;
    private int ammunition = 100;

    private int direction = 0;

    private static final int speed = 2;

    private static int width = 64, height = 64;

    public ArrayList getBullets() {
        return bullets;
    }

    public Player() {
        bullets = new ArrayList<Bullet>();
    }

    public String getIcon() { return "player.png"; }

    public void fire() {
        bullets.add(
            // Spawn the bullet at the center of the player
            new Bullet(x + (width / 2), y + (height / 2), direction)
        );
        System.out.printf("Spawned bullet with direction %d\n", Math.abs(direction));
    }

    /**
     * Get the
     * @param x
     * @param y
     * @return int The watch direction in radians
     */
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

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) dy = -speed; // Up
        if(key == KeyEvent.VK_S) dy = speed;  // Down
        if(key == KeyEvent.VK_A) dx = -speed; // Left
        if(key == KeyEvent.VK_D) dx = speed;  // Right

        if(key == KeyEvent.VK_SPACE) fire();
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) dy = 0; // Up
        if(key == KeyEvent.VK_S) dy = 0; // Down
        if(key == KeyEvent.VK_A) dx = 0; // Left
        if(key == KeyEvent.VK_D) dx = 0; // Right
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public AffineTransform getAffineTransform() {
        AffineTransform trans = new AffineTransform();
        trans.translate(x, y);
        trans.rotate(Math.toRadians(direction), width / 2, height / 2);

        return trans;
    }
}
