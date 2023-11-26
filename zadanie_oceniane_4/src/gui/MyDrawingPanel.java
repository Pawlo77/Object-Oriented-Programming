package gui;

import models.Racer;
import options.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyDrawingPanel extends JPanel {
    private final AtomicBoolean raceInProgress;
    private List<Racer> racers;

    public MyDrawingPanel(AtomicBoolean raceInProgress) {
        super();
        this.raceInProgress = raceInProgress;
    }

    public void myRepaint(List<Racer> racers) {
        this.racers = racers;
        super.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawLine(Settings.getLeftPad(), Settings.getLineHeight(), Settings.getPanelWidth() - Settings.getRightPad(), Settings.getLineHeight());

        g.setColor(Color.BLUE);
        FontMetrics fm = g.getFontMetrics();
        String startText = "Start";
        int startX = Settings.getLeftPad() + (Settings.getPanelWidth() - Settings.getLeftPad() - Settings.getRightPad() - fm.stringWidth(startText)) / 2;
        int startY = Settings.getStartStringHeight() - fm.getHeight() / 2;
        g.drawString(startText, startX, startY);

        g.setColor(Color.RED);
        String finishText = "Meta";
        int finishX = Settings.getLeftPad() + (Settings.getPanelWidth() - Settings.getLeftPad() - Settings.getRightPad() - fm.stringWidth(finishText)) / 2;
        int finishY = Settings.getEndStringHeight() - fm.getAscent() / 2;
        g.drawString(finishText, finishX, finishY);

        if (raceInProgress.get()) {
            if (racers != null) for (Racer racer : racers) {
                racer.draw(g);
            }
        }
    }
}
