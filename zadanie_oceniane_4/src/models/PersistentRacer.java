package models;

import models.Racer;

import java.awt.*;

public class PersistentRacer extends Racer {
    private int totalDistance;

    public PersistentRacer(int startX) {
        super(startX, 3);
    }

    @Override
    public Color getColor() {
        return new Color(255, 0, 255);
    }

    @Override
    public void move() {
        this.totalDistance += getSpeed();
        super.move();
    }

    @Override
    public String getId() {
        return Integer.toString(totalDistance);
    }
}