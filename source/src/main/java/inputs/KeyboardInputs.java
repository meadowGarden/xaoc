package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class KeyboardInputs implements KeyListener {
    private final GamePanel gamePanel;

    public KeyboardInputs(final GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
//        keysHandler(e);
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        keysHandler(e);
    }

    @Override
    public void keyReleased(final KeyEvent e) {
//        keysHandler(e);
    }

    private void keysHandler(final KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.updateYDelta(-5);
            case KeyEvent.VK_A -> gamePanel.updateXDelta(-5);
            case KeyEvent.VK_S -> gamePanel.updateYDelta(5);
            case KeyEvent.VK_D -> gamePanel.updateXDelta(5);
        }
    }
}
