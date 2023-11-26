package models;

import options.Settings;

import java.awt.*;

public abstract class Racer {
    private final int x;
    private int y;
    private final int speed;

    public Racer(int startX, int speed) {
        this.x = startX - Settings.getRacerSize();
        this.y = Settings.getStartStringHeight();
        this.speed = speed;
    }

    public void move() {
        this.y += speed;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getY() {
        return y;
    }

    public String getId() {
        return "1";
    }

    public int getSpeed() {
        return speed;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawOval(x, y, Settings.getRacerSize(), Settings.getRacerSize());
    }

    public abstract Color getColor();
}
