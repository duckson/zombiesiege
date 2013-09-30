package nl.duckson.zombiesiege.entity;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: mathijs
 * Date: 23/09/2013
 * Time: 21:04
 */
public class Bullet extends Entity {
    private static Image image;
    public boolean visible = true;

    private final int BULLET_SPEED = 4;

    protected static int width = 8, height = 8;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected static String icon = "bullet.png";

    // @todo: Find a solution for this.
    public String getIcon() { return "bullet.png"; }

    public Image getImage() {
        if(null == image) {
            String image_location = "/res/" + this.getIcon();
            System.out.println("Loading sprite " + image_location);
            ImageIcon ii = new ImageIcon(this.getClass().getResource(image_location));
            image = ii.getImage();
        }
        return image;
    }

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
}
