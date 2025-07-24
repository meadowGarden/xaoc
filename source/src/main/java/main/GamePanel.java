package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final MouseInputs mouseInputs;
    private int xDelta = 100;
    private int yDelta = 100;

    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
        this.mouseInputs = new MouseInputs(this);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void updateXDelta(final int value) {
        this.xDelta += value;
        repaint();
    }

    public void updateYDelta(final int value) {
        this.yDelta += value;
        repaint();
    }

    public void setRectPosition(final int x, final int y) {
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }


    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.fillRect(this.xDelta, this.yDelta, 200, 50);
    }

}
