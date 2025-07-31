package main;

public final class Game implements Runnable {
    private final GameWindow gameWindow;
    private final GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_DEFAULT = 120;

    public Game() {
        this.gamePanel = new GamePanel();
        this.gameWindow = new GameWindow(gamePanel);
        this.gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        this.gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1_000_000_000f / FPS_DEFAULT;
        long previousTime = System.nanoTime();
        long frames = 0;
        long lastCheck = 0;

        while (true) {
            final long now = System.nanoTime();
            if (now - previousTime >= timePerFrame) {
                gamePanel.repaint();
                previousTime = now;
                frames++;
            }

            if (now - lastCheck >= 1_000_000_000) {
                lastCheck = System.nanoTime();
                System.out.println(frames);
                frames = 0;
            }
        }
    }
}
