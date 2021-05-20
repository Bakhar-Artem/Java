package by.bakhar.game.frame;

import by.bakhar.game.reader.PictureReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class GamePanel extends JPanel implements KeyListener {
    private static final int WIGHT = 548;
    private static final int HIGH = 548;
    private static final int LINE_LENGTH = 137;
    private int[][] matrixOfPicture;
    private List<BufferedImage> imageList;

    public GamePanel() throws IOException {
        setSize(new Dimension(WIGHT, HIGH));
        matrixOfPicture = new int[4][4];
        imageList = PictureReader.readImages();
    }

    private int countImagePos(int value) {
        int result;
        switch (value) {
            case (0) -> result = 0;
            case (2) -> result = 4;
            case (4) -> result = 8;
            case (8) -> result = 11;
            case (16) -> result = 3;
            case (32) -> result = 7;
            case (64) -> result = 10;
            case (128) -> result = 2;
            case (256) -> result = 6;
            case (512) -> result = 9;
            case (1024) -> result = 1;
            case (2048) -> result = 5;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
        return result;
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i <= 4; i++) {
            g.drawLine(LINE_LENGTH * i, 0, LINE_LENGTH * i, HIGH);
            g.drawLine(0, LINE_LENGTH * i, WIGHT, LINE_LENGTH * i);
        }
        for (int i = 0; i < matrixOfPicture.length; i++) {
            for (int j = 0; j < matrixOfPicture[i].length; j++) {
                int value = matrixOfPicture[i][j];
                value=countImagePos(2048);
                g.drawImage(imageList.get(value), LINE_LENGTH * i + 5, LINE_LENGTH * j + 5, null);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int value=e.getKeyCode();
        switch (value){
            case 37-> {
            }
            case 38-> {
            }
            case 39-> {
            }
            case 40-> {

            }
        }
    }
}
