package nl.duckson.zombiesiege.entity;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: mathijs
 * Date: 23/09/2013
 * Time: 17:21
 */
public class Player extends Entity {
    public ArrayList<Bullet> bullets;
    protected int ammunition = 100;

    protected static int width = 64, height = 64;


    public ArrayList getBullets() { return bullets; }

    public Player() {
        bullets = new ArrayList<Bullet>();
    }

    public String getIcon() { return "player.png"; }

    public void fire() {
        bullets.add(
            new Bullet(x + (width / 2), y + (height / 2))
        );
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) dy = -1; // Up
        if(key == KeyEvent.VK_S) dy = 1;  // Down
        if(key == KeyEvent.VK_A) dx = -1; // Left
        if(key == KeyEvent.VK_D) dx = 1;  // Right

        if(key == KeyEvent.VK_SPACE) fire();
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) dy = 0; // Up
        if(key == KeyEvent.VK_S) dy = 0; // Down
        if(key == KeyEvent.VK_A) dx = 0; // Left
        if(key == KeyEvent.VK_D) dx = 0; // Right
    }
}
