package by.bakhar.game.main;

import by.bakhar.game.frame.GameGrid;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new GameGrid();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
