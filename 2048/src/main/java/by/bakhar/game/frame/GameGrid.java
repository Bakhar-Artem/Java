package by.bakhar.game.frame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameGrid extends JFrame {
    public GameGrid() throws HeadlessException, IOException {
        super("2048");
        setSize(new Dimension(560, 580));
        setLocationRelativeTo(null);
        add(new GamePanel());
    }
}
