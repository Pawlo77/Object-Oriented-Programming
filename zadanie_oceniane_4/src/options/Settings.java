package options;

public class Settings {
    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 600;
    private static final int LEFT_PAD = 10;
    private static final int RIGHT_PAD = 10;
    private static final int RACER_SIZE = 10;
    private static final int LINE_HEIGHT = PANEL_HEIGHT / 2;
    private static final int START_STRING_HEIGHT = PANEL_HEIGHT / 10;
    private static final int END_STRING_HEIGHT = 8 * PANEL_HEIGHT / 10;

    public static int getPanelWidth() {
        return PANEL_WIDTH;
    }

    public static int getPanelHeight() {
        return PANEL_HEIGHT;
    }

    public static int getLineHeight() {
        return LINE_HEIGHT;
    }

    public static int getStartStringHeight() {
        return START_STRING_HEIGHT;
    }

    public static int getEndStringHeight() {
        return END_STRING_HEIGHT;
    }

    public static int getLeftPad() {
        return LEFT_PAD;
    }

    public static int getRightPad() {
        return RIGHT_PAD;
    }

    public static int getRacerSize() {
        return RACER_SIZE;
    }
}
