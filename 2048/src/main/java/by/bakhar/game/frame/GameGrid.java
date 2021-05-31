package by.bakhar.game.frame;

import by.bakhar.game.service.MoveService;
import by.bakhar.game.service.Toward;
import by.bakhar.game.service.impl.MoveServiceImpl;

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
        MoveService moveService = new MoveServiceImpl();
        switch (value) {
            case 37 -> {//left
                moveService.moveToward(matrixOfPicture, Toward.LEFT);
                try {
                    gamePanel.notifyObservers();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            case 39 -> {
                moveService.moveToward(matrixOfPicture, Toward.RIGHT);
                try {
                    gamePanel.notifyObservers();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            case 38 -> {
                moveService.moveToward(matrixOfPicture, Toward.UP);
                try {
                    gamePanel.notifyObservers();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            case 40 -> {
                moveService.moveToward(matrixOfPicture, Toward.DOWN);
                try {
                    gamePanel.notifyObservers();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
