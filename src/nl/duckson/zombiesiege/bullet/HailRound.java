package nl.duckson.zombiesiege.bullet;

public class HailRound extends Bullet {
    private final int travel_distance = 160;

    public HailRound(int x, int y, int d) {
        super(x, y, d);
    }

    public void move() {
        super.move();
        int distance = (int) (travel_distance + Math.random() * 8);

        // Disappear after a while
        if(Math.abs(x - start_x) > distance) {
            setVisible(false);
        }
    }
}
