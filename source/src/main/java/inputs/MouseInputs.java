package inputs;

import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public final class MouseInputs implements MouseListener, MouseMotionListener {
    private final GamePanel gamePanel;

    public MouseInputs(final GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }


    @Override
    public void mouseClicked(final MouseEvent e) {
        System.out.println("oh, you clicked me");
    }

    @Override
    public void mousePressed(final MouseEvent e) {

    }

    @Override
    public void mouseReleased(final MouseEvent e) {

    }

    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    @Override
    public void mouseExited(final MouseEvent e) {

    }

    @Override
    public void mouseDragged(final MouseEvent e) {

    }

    @Override
    public void mouseMoved(final MouseEvent e) {
        gamePanel.setRectPosition(e.getX(), e.getY());
    }
}
