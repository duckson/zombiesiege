package nl.duckson.zombiesiege.bullet;

import nl.duckson.zombiesiege.Game;
import nl.duckson.zombiesiege.entity.Entity;

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
    private int BULLET_SPEED = 4;
    private int travel_distance = 200;

    protected static int width = 8, height = 8;

    protected int start_x = 0, start_y = 0;

    protected int direction = 90;

    public Bullet() {}

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.start_x = x;
        this.start_y = y;
    }

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.start_x = x;
        this.start_y = y;
        this.direction = direction;
    }

    public String getIcon() { return "bullet.png"; }

    public void move() {
        x -= BULLET_SPEED;

        // Turn the bullet invisible once it leaves the board
        // This will remove it entirely shortly afterwards
        if(x > Game.GAME_WIDTH || x < 0 ||
           y > Game.GAME_HEIGHT || y < 0)
            setVisible(false);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
