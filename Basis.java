public class Basis {
    char[][] field;
    int size = 3; // размер поля 3х3
    int count = 3;  // размер выигрышной строки

    void initField() {
        this.field = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                field[row][col] = ' ';
            }
        }
        System.out.println("Поле");
        this.printField();
    }

    void printField() {
        System.out.print("   ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int row = 0; row < size; row++) {
            int rowNum = row + 1;
            System.out.print(rowNum + " ");
            for (int col = 0; col < size; col++) {
                System.out.print("[" + this.field[row][col] + ']');
            }
            System.out.println();
        }
    }

    boolean freePlace(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= size || colIndex < 0 || colIndex >= size) {
            return false;
        } else if (this.field[rowIndex][colIndex] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    void setValue(int rowIndex, int colIndex, char value) {
        this.field[rowIndex][colIndex] = value;
    }

    boolean isGameOver(char player) {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (checkRight(row, col, player)) {
                    return true;
                } else if (checkDown(row, col, player)) {
                    return true;
                } else if (checkRightDiag(row, col, player)) {
                    return true;
                } else if (checkLeftDiag(row, col, player)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkRight(int row, int col, char player) {
        if (col > this.size - this.count) {
            return false;
        }

        for (int i = col; i < col + this.count; i++) {
            if (this.field[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    boolean checkDown(int row, int col, char player) {
        if (row > this.size - this.count) {
            return false;
        }

        for (int i = row; i < row + this.count; i++) {
            if (this.field[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    boolean checkRightDiag(int row, int col, char player) {
        if (row > this.size - this.count) {
            return false;
        }
        if (col > this.size - this.count) {
            return false;
        }

        for (int sdvig = 0; sdvig < this.count; sdvig++) {
            int rowToCheck = row + sdvig;
            int colToCheck = col + sdvig;
            if (this.field[rowToCheck][colToCheck] != player) {
                return false;
            }
        }
        return true;
    }

    boolean checkLeftDiag(int row, int col, char player) {
        if (row > this.size - this.count) {
            return false;
        }
        if (col < this.count - 1) {
            return false;
        }

        for (int sdvig = 0; sdvig < this.count; sdvig++) {
            int rowToCheck = row + sdvig;
            int colToCheck = col - sdvig;
            if (this.field[rowToCheck][colToCheck] != player) {
                return false;
            }
        }
        return true;
    }
}