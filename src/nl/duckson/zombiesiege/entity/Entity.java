package nl.duckson.zombiesiege.entity;

import javax.swing.*;
import java.awt.*;

/**
 * User: mathijs
 * Date: 23/09/2013
 * Time: 17:21
 */
public abstract class Entity {
    protected int x = 0, y = 0;

    /**
     * The Entity's direction on the playing field
     */
    protected int dx, dy;

    /**
     * The width/height of an Entity as it's drawn on the playing field
     */
    protected static int width = 0, height = 0;

    public boolean visible = true;

    protected static int speed = 0;

    protected String icon;
    protected Image image;

    public Image getImage() {
        if(null == image) {
            if(null == this.getIcon()) {
                    System.out.printf("\nNo image available for %s\n",
                            this.getClass().toString());
                    System.exit(1);
            }
            String image_location = "/res/" + this.getIcon();
            System.out.println("Loading sprite " + image_location);
            ImageIcon ii = new ImageIcon(getClass().getResource(image_location));
            image = ii.getImage();
        }

        return image;
    }

    public void setImage(Image i) {
        image = i;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveCenterTo(int x, int y) {
        this.x = x + (width / 2);
        this.y = y + (height / 2);
    }

    public int getX() { return x; }
    public int getY() { return y; }

    abstract public String getIcon();

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean v) {
        visible = v;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean equals(Entity obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(this.x == obj.x && this.y == obj.y) return true;
        return false;
    }
}
