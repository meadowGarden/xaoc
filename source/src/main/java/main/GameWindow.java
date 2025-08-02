package main;

import javax.swing.*;
import java.util.Objects;

public final class GameWindow {
    private final JFrame jFrame;

    public GameWindow(final GamePanel gamePanel) {
        this.jFrame = new JFrame();
        this.jFrame.setTitle("game");
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.setResizable(false);
        this.jFrame.setIconImage(Objects.requireNonNull(getJFrameIcon()).getImage());
        this.jFrame.setLocationRelativeTo(null);

        this.jFrame.add(gamePanel);
        this.jFrame.pack();
        this.jFrame.setVisible(true);
    }

    private ImageIcon getJFrameIcon() {
        final java.net.URL imgURL = getClass().getResource("/images/gipu.jpg");

        if (imgURL != null)
            return new ImageIcon(imgURL);
        return null;
    }
}
