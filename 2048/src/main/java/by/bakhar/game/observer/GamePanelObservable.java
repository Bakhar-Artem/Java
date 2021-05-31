package by.bakhar.game.observer;

import by.bakhar.game.frame.GamePanel;

import java.io.IOException;

public interface GamePanelObservable<T extends GamePanelObserver> {
    void attach(T observer);

    void detach(T observer);

    void notifyObservers() throws IOException;
}
