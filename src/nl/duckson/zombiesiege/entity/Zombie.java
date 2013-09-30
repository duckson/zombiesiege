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
    protected static int width = 64, height = 64;

    public String getIcon() { return "zombie.png"; }

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
        if(x >= Game.GAME_WIDTH- width) dx = -1;

        if(y <= 0) dy = 1;
        if(y >= Game.GAME_HEIGHT - width) dy = -1;

        super.move();
    }
}
