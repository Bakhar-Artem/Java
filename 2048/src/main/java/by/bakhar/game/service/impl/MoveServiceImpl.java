package by.bakhar.game.service.impl;

import by.bakhar.game.service.MoveService;
import by.bakhar.game.service.Toward;

public class MoveServiceImpl implements MoveService {

    @Override
    public void moveToward(int[][] matrix, Toward toward) {
        boolean[] flags = new boolean[4];
        switch (toward) {
            case LEFT -> {
                for (int i = 0; i < matrix.length; i++) {
                    flags[i] = moveLeft(matrix[i]);
                }
                for (int i = 0; i < flags.length; i++) {
                    if (flags[i]) {
                        addValues(matrix);
                        break;
                    }
                }
            }
            case RIGHT -> {
                for (int i = 0; i < matrix.length; i++) {
                    flags[i] = moveRight(matrix[i]);
                }
                for (int i = 0; i < flags.length; i++) {
                    if (flags[i]) {
                        addValues(matrix);
                        break;
                    }
                }
            }
            case UP -> {
                for (int j = 0; j < matrix.length; j++) {
                    flags[j] = moveUp(matrix, j);
                }
                for (int i = 0; i < flags.length; i++) {
                    if (flags[i]) {
                        addValues(matrix);
                        break;
                    }
                }
            }
            case DOWN -> {
                for (int j = 0; j < matrix.length; j++) {
                    flags[j] = moveDown(matrix, j);
                }
                for (int i = 0; i < flags.length; i++) {
                    if (flags[i]) {
                        addValues(matrix);
                        break;
                    }
                }

            }
        }
    }

    private void addValues(int[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (counter == 1) {
                    return;
                }
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 2;
                    counter++;
                }
            }
        }
    }

    private boolean moveLeft(int[] vector) {
        boolean flag = false;
        if (vector[0] == vector[1]) {
            vector[0] += vector[1];
            vector[1] = 0;
            flag = true;
        }
        if (vector[1] != 0 && vector[0] == 0) {
            vector[0] = vector[1];
            vector[1] = 0;
            flag = true;
        }
        if (vector[2] != 0) {
            if (vector[0] == 0 && vector[1] == 0) {
                vector[0] = vector[2];
                vector[2] = 0;
                flag = true;
            } else if (vector[0] != 0 && vector[1] == 0) {
                if (vector[0] == vector[2]) {
                    vector[0] += vector[2];
                } else {
                    vector[1] = vector[2];
                }
                flag = true;
                vector[2] = 0;
            } else if (vector[0] != 0 && vector[1] == vector[2]) {
                vector[1] += vector[2];
                vector[2] = 0;
                flag = true;
            }
        }
        if (vector[3] != 0) {
            if (vector[0] == 0 && vector[1] == 0 && vector[2] == 0) {
                vector[0] = vector[3];
                vector[3] = 0;
                flag = true;
            } else if (vector[0] != 0 && vector[1] == 0 && vector[2] == 0) {
                if (vector[0] == vector[3]) {
                    vector[0] += vector[3];
                } else {
                    vector[1] = vector[3];
                }
                flag = true;
                vector[3] = 0;
            } else if (vector[0] != 0 && vector[1] != 0 && vector[2] == 0) {
                if (vector[1] == vector[3]) {
                    vector[1] += vector[3];
                } else {
                    vector[2] = vector[3];
                }
                flag = true;
                vector[3] = 0;
            } else if (vector[0] != 0 && vector[1] != 0 && vector[2] == vector[3]) {
                vector[2] += vector[3];
                vector[3] = 0;
                flag = true;
            }
        }
        return flag;
    }

    private boolean moveRight(int[] vector) {
        boolean flag = false;
        if (vector[3] == vector[2]) {
            vector[3] += vector[2];
            vector[2] = 0;
            flag = true;
        }
        if (vector[2] != 0) {
            if (vector[3] == 0) {
                vector[3] = vector[2];
                vector[2] = 0;
                flag = true;
            } else if (vector[3] == vector[2]) {
                vector[3] += vector[2];
                vector[2] = 0;
                flag = true;
            }
        }
        if (vector[1] != 0) {
            if (vector[2] == 0 && vector[3] == 0) {
                vector[3] = vector[1];
                vector[1] = 0;
                flag = true;
            } else if (vector[3] != 0 && vector[2] == 0) {
                if (vector[1] == vector[3]) {
                    vector[3] += vector[1];
                } else {
                    vector[2] = vector[1];
                }
                flag = true;
                vector[1] = 0;
            } else if (vector[3] != 0 && vector[2] == vector[1]) {
                vector[2] += vector[1];
                vector[1] = 0;
                flag = true;
            }
        }
        if (vector[0] != 0) {
            if (vector[3] == 0 && vector[1] == 0 && vector[2] == 0) {
                vector[3] = vector[0];
                vector[0] = 0;
                flag = true;
            } else if (vector[3] != 0 && vector[1] == 0 && vector[2] == 0) {
                if (vector[0] == vector[3]) {
                    vector[3] += vector[0];
                } else {
                    vector[2] = vector[0];
                }
                flag = true;
                vector[0] = 0;
            } else if (vector[3] != 0 && vector[2] != 0 && vector[1] == 0) {
                if (vector[0] == vector[2]) {
                    vector[2] += vector[0];
                } else {
                    vector[1] = vector[0];
                }
                flag = true;
                vector[0] = 0;
            } else if (vector[3] != 0 && vector[2] != 0 && vector[1] == vector[0]) {
                vector[1] += vector[0];
                vector[0] = 0;
                flag = true;
            }
        }
        return flag;
    }

    private boolean moveUp(int[][] matrix, int j) {
        boolean flag = false;
        if (matrix[0][j] == matrix[1][j]) {
            matrix[0][j] += matrix[1][j];
            matrix[1][j] = 0;
            flag = true;
        }
        if (matrix[1][j] != 0 && matrix[0][j] == 0) {
            matrix[0][j] = matrix[1][j];
            matrix[1][j] = 0;
            flag = true;
        }
        if (matrix[2][j] != 0) {
            if (matrix[1][j] == 0 && matrix[0][j] == 0) {
                matrix[0][j] = matrix[2][j];
                matrix[2][j] = 0;
                flag = true;
            } else if (matrix[1][j] == 0 && matrix[0][j] != 0) {
                if (matrix[0][j] == matrix[2][j]) {
                    matrix[0][j] += matrix[2][j];
                } else {
                    matrix[1][j] = matrix[2][j];
                }
                flag = true;
                matrix[2][j] = 0;
            } else if (matrix[2][j] == matrix[1][j] && matrix[0][j] != 0) {
                matrix[1][j] += matrix[2][j];
                matrix[2][j] = 0;
                flag = true;
            }
        }
        if (matrix[3][j] != 0) {
            if (matrix[1][j] == 0 && matrix[0][j] == 0 && matrix[2][j] == 0) {
                matrix[0][j] = matrix[3][j];
                matrix[3][j] = 0;
                flag = true;
            } else if (matrix[1][j] == 0 && matrix[0][j] != 0 && matrix[2][j] == 0) {
                if (matrix[0][j] == matrix[3][j]) {
                    matrix[0][j] += matrix[3][j];
                } else {
                    matrix[1][j] = matrix[3][j];
                }
                flag = true;
                matrix[3][j] = 0;
            } else if (matrix[1][j] != 0 && matrix[0][j] != 0 && matrix[2][j] == 0) {
                if (matrix[1][j] == matrix[3][j]) {
                    matrix[1][j] += matrix[3][j];
                } else {
                    matrix[2][j] = matrix[3][j];
                }
                flag = true;
                matrix[3][j] = 0;
            } else if (matrix[1][j] != 0 && matrix[0][j] != 0 && matrix[2][j] == matrix[3][j]) {
                matrix[2][j] += matrix[3][j];
                matrix[3][j] = 0;
                flag = true;
            }
        }
        return flag;
    }

    private boolean moveDown(int[][] matrix, int j) {
        boolean flag = false;
        if (matrix[2][j] == matrix[3][j]) {
            matrix[3][j] += matrix[2][j];
            matrix[2][j] = 0;
            flag = true;
        }
        if (matrix[2][j] != 0 && matrix[3][j] == 0) {
            matrix[3][j] = matrix[2][j];
            matrix[2][j] = 0;
            flag = true;
        }
        if (matrix[1][j] != 0) {
            if (matrix[3][j] == 0 && matrix[2][j] == 0) {
                matrix[3][j] = matrix[1][j];
                matrix[1][j] = 0;
                flag = true;
            } else if (matrix[2][j] == 0 && matrix[3][j] != 0) {
                if (matrix[3][j] == matrix[1][j]) {
                    matrix[3][j] += matrix[1][j];
                } else {
                    matrix[2][j] = matrix[1][j];
                }
                flag = true;
                matrix[1][j] = 0;
            } else if (matrix[2][j] == matrix[1][j] && matrix[3][j] != 0) {
                matrix[2][j] += matrix[1][j];
                matrix[1][j] = 0;
                flag = true;
            }
        }
        if (matrix[0][j] != 0) {
            if (matrix[1][j] == 0 && matrix[2][j] == 0 && matrix[3][j] == 0) {
                matrix[3][j] = matrix[0][j];
                matrix[0][j] = 0;
                flag = true;
            } else if (matrix[1][j] == 0 && matrix[3][j] != 0 && matrix[2][j] == 0) {
                if (matrix[0][j] == matrix[3][j]) {
                    matrix[3][j] += matrix[0][j];
                } else {
                    matrix[2][j] = matrix[0][j];
                }
                flag = true;
                matrix[0][j] = 0;
            } else if (matrix[3][j] != 0 && matrix[2][j] != 0 && matrix[1][j] == 0) {
                if (matrix[0][j] == matrix[2][j]) {
                    matrix[2][j] += matrix[0][j];
                } else {
                    matrix[1][j] = matrix[0][j];
                }
                flag = true;
                matrix[0][j] = 0;
            } else if (matrix[3][j] != 0 && matrix[2][j] != 0 && matrix[1][j] == matrix[0][j]) {
                matrix[1][j] += matrix[0][j];
                matrix[0][j] = 0;
                flag = true;
            }
        }
        return flag;
    }

}
