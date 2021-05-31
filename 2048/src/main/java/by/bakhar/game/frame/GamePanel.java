package by.bakhar.game.frame;

import by.bakhar.game.observer.GamePanelEvent;
import by.bakhar.game.observer.GamePanelObservable;
import by.bakhar.game.observer.GamePanelObserver;
import by.bakhar.game.observer.impl.GamePanelObserverImpl;
import by.bakhar.game.reader.PictureReader;
import by.bakhar.game.service.CountImageService;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePanel extends JPanel implements GamePanelObservable<GamePanelObserver> {
    private static final int WIGHT = 548;
    private static final int HIGH = 548;
    private static final int LINE_LENGTH = 137;
    private int[][] matrixOfPicture;
    private List<BufferedImage> imageList;
    private List<GamePanelObserver> observerList=new ArrayList<>();


    public GamePanel() throws IOException {
        setSize(new Dimension(WIGHT, HIGH));
        matrixOfPicture = new int[4][4];
        int value=CountImageService.countImagePos(0);
        for (int[] ints : matrixOfPicture) {
            Arrays.fill(ints, value);
        }
        matrixOfPicture[2][2]= 2;
        matrixOfPicture[3][3]= 2;
        imageList = PictureReader.readImages();
        attach(new GamePanelObserverImpl());

    }

    public int[][] getMatrixOfPicture() {
        return matrixOfPicture;
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <= 4; i++) {
            g.drawLine(LINE_LENGTH * i, 0, LINE_LENGTH * i, HIGH);
            g.drawLine(0, LINE_LENGTH * i, WIGHT, LINE_LENGTH * i);
        }
        for (int i = 0; i < matrixOfPicture.length; i++) {
            for (int j = 0; j < matrixOfPicture[i].length; j++) {
                int pos = CountImageService.countImagePos(matrixOfPicture[i][j]);
                g.drawImage(imageList.get(pos), LINE_LENGTH * j + 5, LINE_LENGTH * i + 5, null);
            }
        }

    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void attach(GamePanelObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(GamePanelObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() throws IOException {
        GamePanelEvent event = new GamePanelEvent(this);
        for (GamePanelObserver observer : observerList) {
            observer.repaint(event.getSource());
        }
    }
}
