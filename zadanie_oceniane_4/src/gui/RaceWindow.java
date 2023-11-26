package gui;

import models.PersistentRacer;
import models.Racer;
import models.StableRacer;
import options.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceWindow extends JFrame {
    private final MyDrawingPanel drawingPanel;
    private final JButton alignmentButton;
    private final JTextField textField;

    private List<Racer> racers;

    private final static Random random = new Random();
    private final AtomicBoolean raceInProgress;
    private final AtomicInteger finishedRacersCount;

    public RaceWindow() {
        super("Paweł Pozorski – mój program wyścigowy!");

        raceInProgress = new AtomicBoolean(false);
        finishedRacersCount = new AtomicInteger(0);

        drawingPanel = new MyDrawingPanel(raceInProgress);
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!raceInProgress.get()) {
                    int numberOfStableRacers = random.nextInt(1, 5);
                    int numberOfPersistentRacers = random.nextInt(1, 5);
                    int spaceBetweenRacers = (Settings.getPanelWidth() - Settings.getLeftPad()) / (numberOfPersistentRacers + numberOfStableRacers + 1);

                    racers = new ArrayList<>();
                    for (int i = 0; i < numberOfStableRacers; i++) {
                        int startX = Settings.getLeftPad() + (i + 1) * spaceBetweenRacers;
                        racers.add(new StableRacer(startX));
                    }
                    for (int i = 0; i < numberOfPersistentRacers; i++) {
                        int startX = Settings.getLeftPad() + (numberOfStableRacers + i + 1) * spaceBetweenRacers;
                        racers.add(new PersistentRacer(startX));
                    }

                    shuffleRacers();
                    raceInProgress.set(true);
                    finishedRacersCount.set(0);
                    drawingPanel.myRepaint(racers);

                    new Thread(() -> startRace()).start();
                }
            }
        });


        JPanel aligmentButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        alignmentButton = new JButton("Przycisk wyrównujący");
        alignmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (finishedRacersCount.get() > 0) {
                    raceInProgress.set(true);
                    finishedRacersCount.set(0);
                    drawingPanel.repaint();

                    new Thread(() -> startRace()).start();
                }
            }
        });
        aligmentButtonPanel.add(alignmentButton);

        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 25));
        textField.setEnabled(false);
        textFieldPanel.add(textField);


        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(drawingPanel, BorderLayout.CENTER);
        getContentPane().add(aligmentButtonPanel, BorderLayout.NORTH);
        getContentPane().add(textFieldPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Settings.getPanelWidth(), Settings.getPanelHeight());
        setVisible(true);
    }

    private void startRace() {
        while (raceInProgress.get()) {
            for (Racer racer : racers) {
                if (!raceInProgress.get()) {
                    break;
                }

                if (racer.getY() < Settings.getEndStringHeight()) {
                    racer.move();
                } else {
                    if (finishedRacersCount.getAndIncrement() == 0) {
                        textField.setText(racer.getId());
                    }
                }

                drawingPanel.repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void shuffleRacers() {
        Random random = new Random();
        for (int i = racers.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Racer temp = racers.get(i);
            this.racers.set(i, racers.get(j));
            this.racers.set(j, temp);
        }
    }
}


