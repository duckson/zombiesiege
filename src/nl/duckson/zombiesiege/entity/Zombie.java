package nl.duckson.zombiesiege.entity;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: mathijs
 * Date: 23/09/2013
 * Time: 17:21
 */
public class Zombie extends Entity {
    protected static String icon = "zombie.png";
    private static Image image;

    protected static int width = 64, height = 64;

    // @todo: Find a solution for this.
    @Override
    public String getIcon() { return "zombie.png"; }

    public Image getImage() {
        if(null == image) {
            String image_location = "/res/" + this.getIcon();
            System.out.println("Loading sprite " + image_location);
            ImageIcon ii = new ImageIcon(this.getClass().getResource(image_location));
            image = ii.getImage();
        }
        return image;
    }

    public Zombie() {
        setRandomMovement();
    }

    private void setRandomMovement() {
        if(Math.random() > .5) dx = 1;
        else dx = -1;

        if(Math.random() > .5) dy = 1;
        else dy = -1;
    }

    public void move() {
        if(Math.random() > .99) setRandomMovement();

        // Detect the board's edges

        if(x <= 0) dx = 1;
        if(x >= BOARD_WIDTH - width) dx = -1;

        if(y <= 0) dy = 1;
        if(y >= BOARD_HEIGHT - width) dy = -1;

        super.move();
    }
}
