package ru.alina_corp.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {


    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static final int WIN_COUNT = 4; // Выигрышная комбинация


    public static void main(String[] args) {
        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (checkState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация объектов игры
     */
    static void initialize(){
        fieldSizeX = 5;
        fieldSizeY = 5;

        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++){
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");


        for (int x = 0; x < fieldSizeX; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn(){
        int x;
        int y;
        do{
            System.out.print("Введите координаты хода X и Y\n(от 1 до 3) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn(){
        int x;
        int y;

        // Проверка на возможность выигрышного хода для компьютера
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (isCellEmpty(i, j)) {
                    field[i][j] = DOT_AI;
                    if (checkWin(DOT_AI)) {
                        return;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }

        // Проверка на возможность блокировки хода игрока
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (isCellEmpty(i, j)) {
                    field[i][j] = DOT_HUMAN;
                    if (checkWin(DOT_HUMAN)) {
                        field[i][j] = DOT_AI;
                        return;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }

        // Если нет возможности выиграть или заблокировать ход игрока, делаем случайный ход
        do{
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }
    /**
     * Проверка валидности координат хода
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
    /**
     * Поверка на ничью (все ячейки игрового поля заполнены фишками человека или компьютера)
     * @return
     */
    static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (field[x][y] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * TODO: Переработать в рамках домашней работы
     * Метод проверки победы
     * @param dot фишка игрока
     * @return результат проверки победы
     */
    static boolean checkWin(char dot){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (checkLine(x, y, 1, 0, dot) || // горизонтальная линия
                        checkLine(x, y, 0, 1, dot) || // вертикальная линия
                        checkLine(x, y, 1, 1, dot) || // диагональная линия \
                        checkLine(x, y, 1, -1, dot)){ // диагональная линия /
                    return true;
                }
            }
        }
        return false;

    }

    static boolean checkLine(int startX, int startY, int dirX, int dirY, char dot){
        for (int i = 0; i < WIN_COUNT; i++){
            int x = startX + i * dirX;
            int y = startY + i * dirY;
            if (!isCellValid(x, y) || field[x][y] != dot){
                return false;
            }
        }
        return true;
    }


    /**
     * Проверка состояния игры
     * @param dot фишка игрока
     * @param winMessage победный слоган
     * @return состояние игры
     */
    static boolean checkState(char dot, String winMessage){
        if (checkWin(dot)){
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

}
