package main;

public final class Game {
    private final GameWindow gameWindow;
    private final GamePanel gamePanel;

    public Game() {
        this.gamePanel = new GamePanel();
        this.gameWindow = new GameWindow(gamePanel);
        this.gamePanel.requestFocus();
    }
}
