package main;

import javax.swing.*;
import java.util.Objects;

public class GameWindow {
    private final JFrame jFrame;

    public GameWindow(final GamePanel gamePanel) {
        jFrame = new JFrame();
        jFrame.setTitle("game");
        jFrame.setSize(1200, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setIconImage(Objects.requireNonNull(getJFrameIcon()).getImage());
        jFrame.setLocationRelativeTo(null);

        jFrame.add(gamePanel);
        jFrame.setVisible(true);
    }

    private ImageIcon getJFrameIcon() {
        java.net.URL imgURL = getClass().getResource("/images/gipu.jpg");

        if (imgURL != null)
            return new ImageIcon(imgURL);
        return null;
    }
}
