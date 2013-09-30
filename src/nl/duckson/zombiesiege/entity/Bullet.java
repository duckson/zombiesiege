package nl.duckson.zombiesiege.entity;

import nl.duckson.zombiesiege.Game;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: mathijs
 * Date: 23/09/2013
 * Time: 21:04
 */
public class Bullet extends Entity {
    public boolean visible = true;

    private final int BULLET_SPEED = 4;

    protected static int width = 8, height = 8;

    protected int direction = 90;

    public Bullet() {}
    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String getIcon() { return "bullet.png"; }

    public boolean isVisible() {
        return visible;
    }

    public void move() {
        x -= BULLET_SPEED;

        // Turn the bullet invisible once it leaves the board
        // This will remove it entirely shortly afterwards
        if(x > Game.GAME_WIDTH || x < 0 ||
           y > Game.GAME_HEIGHT || y < 0)
            visible = false;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
