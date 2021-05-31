package by.bakhar.game.observer.impl;

import by.bakhar.game.frame.GamePanel;
import by.bakhar.game.observer.GamePanelObserver;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class GamePanelObserverImpl implements GamePanelObserver {
    @Override
    public void repaint(GamePanel gamePanel) throws IOException {
        int[][] matrix = gamePanel.getMatrixOfPicture();
        if (checkWin(matrix)) {
            for (int[] ints : matrix) {
                Arrays.fill(ints, 2048);
            }
            JOptionPane.showMessageDialog(null, "You win!", "winner", JOptionPane.INFORMATION_MESSAGE);
        }
        if (checkLose(matrix)) {
            for (int[] ints : matrix) {
                Arrays.fill(ints, 0);
            }
            JOptionPane.showMessageDialog(null, "You lose!", "looser", JOptionPane.INFORMATION_MESSAGE);
        }
        gamePanel.repaint();
    }

    private boolean checkWin(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 && j > 0 && j < 3) {
                    if (matrix[i][j] == matrix[i + 1][j] || matrix[i][j] == matrix[i][j - 1] || matrix[i][j] == matrix[i][j + 1]) {
                        return false;
                    }
                } else if (i == 3 && j > 0 && j < 3) {
                    if (matrix[i][j] == matrix[i - 1][j] || matrix[i][j] == matrix[i][j - 1] || matrix[i][j] == matrix[i][j + 1]) {
                        return false;
                    }
                } else if (j == 0 && i > 0 && i < 3) {
                    if (matrix[i][j] == matrix[i - 1][j] || matrix[i][j] == matrix[i + 1][j] || matrix[i][j] == matrix[i][j + 1]) {
                        return false;
                    }
                } else if (j == 3 && i > 0 && i < 3) {
                    if (matrix[i][j] == matrix[i - 1][j] || matrix[i][j] == matrix[i + 1][j] || matrix[i][j] == matrix[i][j - 1]) {
                        return false;
                    }
                } else if (i == 0 && j == 0) {
                    if (matrix[i][j] == matrix[i][j + 1] || matrix[i][j] == matrix[i + 1][j]) {
                        return false;
                    }
                } else if (i == 3 && j == 0) {
                    if (matrix[i][j] == matrix[i][j + 1] || matrix[i][j] == matrix[i - 1][j]) {
                        return false;
                    }
                } else if (i == 0 && j == 3) {
                    if (matrix[i][j] == matrix[i][j - 1] || matrix[i][j] == matrix[i + 1][j]) {
                        return false;
                    }
                } else if (i == 3 && j == 3) {
                    if (matrix[i][j] == matrix[i][j - 1] || matrix[i][j] == matrix[i - 1][j]) {
                        return false;
                    }
                } else {
                    if (matrix[i][j] == matrix[i - 1][j] || matrix[i][j] == matrix[i + 1][j] || matrix[i][j] == matrix[i][j - 1] || matrix[i][j] == matrix[i][j + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
