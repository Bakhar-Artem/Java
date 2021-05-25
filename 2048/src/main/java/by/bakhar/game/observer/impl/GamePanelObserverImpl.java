package by.bakhar.game.observer.impl;

import by.bakhar.game.frame.GamePanel;
import by.bakhar.game.observer.GamePanelObserver;

public class GamePanelObserverImpl implements GamePanelObserver {
    @Override
    public void repaint(GamePanel gamePanel) {
        gamePanel.revalidate();
        gamePanel.repaint();
    }
}
