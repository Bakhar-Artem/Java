package by.bakhar.game.observer;

import by.bakhar.game.frame.GamePanel;

import java.io.IOException;

public interface GamePanelObserver {
    void repaint(GamePanel gamePanel) throws IOException;
}
