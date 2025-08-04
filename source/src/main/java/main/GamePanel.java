package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilities.Constants.PlayerConstants.*;
import static utilities.Constants.directions.*;

public final class GamePanel extends JPanel {
    private final MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;
    private BufferedImage bufferedImage;
    private BufferedImage[][] animations;
    private int animationTick;
    private int animationIndex;
    private final int animationSpeed = 15;
    private int playerAction = IDLE;
    private int playerDirection = -1;
    private boolean isMoving = false;

    public GamePanel() {
        setPanelSize();
        importImage();
        loadAnimations();
        this.addKeyListener(new KeyboardInputs(this));
        this.mouseInputs = new MouseInputs(this);
        this.addMouseListener(mouseInputs);
        this.addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];

        for (int row = 0; row < animations.length; row++)
            for (int col = 0; col < animations[row].length; col++)
                animations[row][col] = bufferedImage.getSubimage(col * 64, row * 40, 64, 40);
    }

    private void importImage() {
        try (final InputStream is = this.getClass().getResourceAsStream("/images/player_sprites.png")) {
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

    public void setDirection(final int direction) {
        this.playerDirection = direction;
        isMoving = true;
    }

    public void setMoving(final boolean isMoving) {
        this.isMoving = isMoving;
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();
        setAnimation();
        updatePosition();

        g.drawImage(animations[playerAction][animationIndex], (int)xDelta, (int)yDelta, 128, 80, null);
    }

    private void updatePosition() {
        if (isMoving) {
            switch (playerDirection) {
                case UP -> yDelta -= 5;
                case LEFT -> xDelta -= 5;
                case DOWN -> yDelta += 5;
                case RIGHT -> xDelta += 5;
            }
        }
    }

    private void setAnimation() {
        if (isMoving)
            playerAction = RUN;
        else
            playerAction = IDLE;
    }

    private void updateAnimationTick() {
        animationTick++;

        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;

            if (animationIndex >= getSpriteAmount(playerAction))
                animationIndex = 0;
        }
    }
}
