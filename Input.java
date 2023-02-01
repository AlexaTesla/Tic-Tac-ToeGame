import java.util.Scanner;

public class Input {
    Basis gameField;
    Scanner sc = new Scanner(System.in);
    char nextTurn;
    boolean gameOver = false;

    void newGame() {
        System.out.println("Новая игра");
        this.gameField = new Basis();
        this.gameField.initField();
    }

    void play() {
        this.newGame();
        System.out.print("Кто ходит первый? ");
        String next = this.sc.next();
        char o1 = next.charAt(0);
        if (o1 == 'X' || o1 == '0') {
            this.nextTurn = o1;
        } else {
            System.out.println("Я могу считывать только Х или 0. Первый ход будет Х");
            this.nextTurn = 'X';
        }
        while (!gameOver){
            turn();
            this.gameOver = this.gameField.isGameOver(this.nextTurn);
            if (this.gameOver){
                System.out.println(this.nextTurn + " win!");
            }
            if (this.nextTurn =='X') {
                this.nextTurn = '0';
            }else {
                this.nextTurn = 'X';
            }
        }
    }

    void turn(){
        System.out.println(this.nextTurn + ", ваш ход. ");
        System.out.print("Введите строку(row): ");
        int rowNum = this.sc.nextInt();
        System.out.print("Введите столбец(col): ");
        int colNum = this.sc.nextInt();
        int rowIndex = rowNum - 1;
        int colIndex = colNum - 1;
        if (this.gameField.freePlace(rowIndex,colIndex)) {
            this.gameField.setValue(rowIndex, colIndex, nextTurn);
            this.gameField.printField();
        }else {
            System.out.println("Эта клетка занята, введите другую. ");
            turn();
        }
    }
}