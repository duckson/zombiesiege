package nl.duckson.zombiesiege.weapon;

import nl.duckson.zombiesiege.Game;
import nl.duckson.zombiesiege.bullet.Bullet;
import nl.duckson.zombiesiege.bullet.FastRound;

public class Revolver extends Handgun {

    public Bullet newBullet() {
        Bullet b = new Bullet();
        b.setSpeed(b.getSpeed() * 2);
        return b;
    }
    public Bullet newBullet(int x, int y, int direction) {
        Bullet b = new Bullet(x, y, direction);
        b.setSpeed(b.getSpeed() * 2);
        return b;
    }

    @Override
    public String getName() {
        return "Revolver";
    }

    // Sounds
    public void playFireSound() {
        Game.playSound("weapon/revolver/revolver_fire.wav");
    }
}
