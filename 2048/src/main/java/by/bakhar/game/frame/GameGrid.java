package by.bakhar.game.frame;

import by.bakhar.game.service.CountImageService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class GameGrid extends JFrame implements KeyListener {

    private GamePanel gamePanel;

    public GameGrid() throws HeadlessException, IOException {
        super("2048");
        setSize(new Dimension(560, 580));
        setLocationRelativeTo(null);
        gamePanel = new GamePanel();
        add(gamePanel);
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int[][] matrixOfPicture = gamePanel.getMatrixOfPicture();
        int value = e.getKeyCode();
        switch (value) {
            case 37 -> {//left
                boolean flag = true;
                while (flag) {
                    for (int i = 0; i < matrixOfPicture.length; i++) {
                        for (int j = 0; j < matrixOfPicture[i].length; j++) {
                            if (j != 0 && matrixOfPicture[i][j] != CountImageService.countImagePos(0)) {
                                matrixOfPicture[i][j - 1] = matrixOfPicture[i][j];
                                matrixOfPicture[i][j] = CountImageService.countImagePos(0);
                                flag = false;
                            }
                        }
                        flag = !flag;
                    }
                }
                gamePanel.notifyObservers();
            }
        }
    }
}
