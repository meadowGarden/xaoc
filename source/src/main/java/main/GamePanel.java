package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public final class GamePanel extends JPanel {
    private final MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;
    private BufferedImage bufferedImage;
    private BufferedImage playerSubImage;

    public GamePanel() {
        setPanelSize();
        importImage();
        this.addKeyListener(new KeyboardInputs(this));
        this.mouseInputs = new MouseInputs(this);
        this.addMouseListener(mouseInputs);
        this.addMouseMotionListener(mouseInputs);
    }

    private void importImage() {
        final InputStream is = this.getClass().getResourceAsStream("/images/player_sprites.png");
        try {
            bufferedImage = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        final Dimension defaultSize = new Dimension(1280, 800);
        this.setMinimumSize(defaultSize);
        this.setPreferredSize(defaultSize);
        this.setMaximumSize(defaultSize);
    }

    public void updateXDelta(final int value) {
        this.xDelta += value;
    }

    public void updateYDelta(final int value) {
        this.yDelta += value;
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        playerSubImage = bufferedImage.getSubimage(1 * 64, 8 * 40, 64, 40);
        g.drawImage(playerSubImage, (int)this.xDelta, (int)this.yDelta, 128, 80, null);
    }
}
