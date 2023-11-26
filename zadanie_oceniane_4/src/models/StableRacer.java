package models;

import models.Racer;

import java.awt.*;
import java.util.Random;

public class StableRacer extends Racer {
    public StableRacer(int startX) {
        super(startX, new Random().nextInt(1, 4));
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
