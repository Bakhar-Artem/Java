package by.bakhar.game.observer;

import by.bakhar.game.frame.GamePanel;

import java.util.EventObject;

public class GamePanelEvent extends EventObject {
    public GamePanelEvent(Object source) {
        super(source);
    }

    @Override
    public GamePanel getSource() {
        return (GamePanel) super.getSource();
    }
}
