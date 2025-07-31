package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public final class GamePanel extends JPanel {
    private final MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;
    private float xDir = 1f;
    private float yDir = 1f;
    private final Random random = new Random();
    private Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
        this.mouseInputs = new MouseInputs(this);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void updateXDelta(final int value) {
        this.xDelta += value;
    }

    public void updateYDelta(final int value) {
        this.yDelta += value;
    }

    public void setRectPosition(final int x, final int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        updateRectangle(g);
        g.setColor(color);
        g.fillRect((int)this.xDelta, (int)this.yDelta, 200, 50);

    }

    private void updateRectangle(final Graphics g) {
        xDelta += xDir;
        if (xDelta > 1200 || xDelta < 0) {
            xDir *= -1;
            color = getRandomColor();
        }

        yDelta += yDir;
        if (yDelta > 600 || yDelta < 0) {
            yDir *= -1;
            color = getRandomColor();
        }
    }

    private Color getRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
