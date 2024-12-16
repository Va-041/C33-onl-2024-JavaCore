

        // !!! 1. Создать возможность передачи заданных параметров, т.е. от ИИ и человекa
        // !!! 2. Эти параметры использовать и вставить в таблицу
        // !!! 3. Учитывая то, какой игрок начал первым, символ должен отличаться (1 = X, 2 = O)
        // !!! 4. После, продолжаем играть, вставляем и учитываем то, занята колонка или нет
        // !!! 4.1. Если уже там есть место, надо проверить и заставить игрока и ИИ поменять свое решение пока не будет
        // !!! 4.1.1. найдено свободное место.
        // !!! 5. Надо добавить счетчик - который будет считать количество шагов, он упростит решение и сможет вам
        // !!! 5.1. подсказать, когда уже время проверить статус, или же и вовсе мест для шага не должно быть.
        // !!! 5.2. Если мы играем по правилу 3х3 то, победа возможна лишь на 5 шаге, а 9 шаг в любом случае значит
        // !!! 5.3. конец, т.е. если к этому моменты никто не победил, то ничья автоматом.
        // !!! 6. Сделать проверку, победа по горизонтали, победа по вертикали, и по крестам - счетчик
        // !!! 7. Игра закончена в ничью, победой игрока или поражением, выводим сообщение и продолжаем играть
        // !!! 7.1. Или же конец.




package lesson6.homework.TicTacToe.game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    private static String player1Name;
    private static String player2Name;

    public static void main(String[] args) {
        startGame();
    }



    // Start the game
    public static void startGame() {
        boolean playAgain = true;
        Scanner scanner = getInputValue();

        while (playAgain) {
            System.out.print("\u001B[36m\nChoose mode: (1) Player vs AI (2) Player vs Player: \u001B[0m");
            String mode = scanner.nextLine();

            if (mode.equals("1")) {
                player1Name = "Player";
                player2Name = "AI";
            } else if (mode.equals("2")) {
                System.out.print("Enter name for Player 1: ");
                player1Name = scanner.nextLine();
                System.out.print("Enter name for Player 2: ");
                player2Name = scanner.nextLine();
            } else {
                System.out.println("\u001B[31mInvalid choice. Please select 1 or 2.\u001B[0m");
                continue;
            }
            getInitialMessage();

            // Create a 3x3 matrix
            char[][] gameTable = createInitializeTable();
            drawTable(gameTable);

            // Throw a dice to decide who starts
            int dice = getRandomNumbers().nextInt(0, 21);
            boolean playerTurn = dice >= 0 && dice <= 10;

            boolean isRunning = true;
            while (isRunning) {
                if (playerTurn) {
                    makePlayerMove(gameTable, player1Name);
                } else {
                    if (player2Name.equals("AI")) {
                        makeAIMove(gameTable);
                    } else {
                        makePlayerMove(gameTable, player2Name);
                    }
                }
                drawTable(gameTable);
                isRunning = !checkStatus(gameTable);
                playerTurn = !playerTurn; // Switch turns
            }

            // Ask if the player wants to play again
            System.out.print("\u001B[36m" + "\nWould you like to play again? (y - Yes, n - No): " + "\u001B[0m");
            playAgain = scanner.nextLine().equals("y");
        }
        scanner.close();
    }

    public static char[][] createInitializeTable() {
        return new char[][]{
                {'*', '*', '*'},
                {'*', '*', '*'},
                {'*', '*', '*'}
        };
    }

    public static void getInitialMessage() {
        System.out.println("\u001B[34m\t");
        System.out.println("----------------------------- WELCOME TO TIC-TAC-TOE GAME ------------------------------");
        System.out.println("Instructions:");
        System.out.println("\t1. The game will draw a table.");
        System.out.println("\t2. The game will decide who starts first.");
        System.out.println("\t3. If a player starts the game, they will use 'X'.");
        System.out.println("\t4. If AI starts the game, the player will use 'O'.");
        System.out.println("\u001B[0m");
        System.out.println("\u001B[34m" + "-----------------------------------------------------------------------" +
                "-----------------" + "\u001B[0m");
    }

    public static void drawTable(char[][] gameTable) {
        System.out.println("\u001B[32m");
        for (char[] outer : gameTable) {
            for (char inner : outer) {
                if (inner == 'X') {
                    System.out.print("\u001B[35m" + inner + "\u001B[0m  "); // Фиолетовый для X
                } else if (inner == 'O') {
                    System.out.print("\u001B[36m" + inner + "\u001B[0m  "); // Голубой для O
                } else {
                    System.out.print("\u001B[32m" + inner + "\u001B[0m  "); // Зеленый для звездочек
                }
            }
            System.out.println();
        }
        System.out.println("\u001B[0m");
    }

    public static void makePlayerMove(char[][] gameTable, String playerName) {
        System.out.println(playerName + "'s turn ");

        while (true) {
            System.out.print("Please, enter coordinates (cell column) (e.g., 1 3): ");
            String input = getInputValue().nextLine(); // Check string length and space between two digits
            if (input.length() == 3 && input.charAt(1) == ' ') {
                int cellPlayer = input.charAt(0) - '1';
                int columnPlayer = input.charAt(2) - '1';
                if (cellPlayer >= 0 && cellPlayer < 3 && columnPlayer >= 0 && columnPlayer < 3) {
                    if (gameTable[cellPlayer][columnPlayer] == '*') {
                        gameTable[cellPlayer][columnPlayer] = (playerName.equals("AI")) ? 'O' : 'X';
                        break;
                    } else {
                        System.out.println("\u001B[31m\tCell is already occupied. Try again.\u001B[0m");
                    }
                } else {
                    System.out.println("\u001B[31m\tInvalid coordinates. Please enter values " +
                            "between 1 and 3.\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31m\tInvalid input format. Please enter coordinates " +
                        "as 'cell column' (e.g., 1 3).\u001B[0m");
            }
        }
    }

    public static void makeAIMove(char[][] gameTable) {
        System.out.println("AI makes a move!");

        // Check if AI should block the player
        if (shouldBlockPlayer(gameTable)) {
            return; // If blocked successfully, exit
        }

        // If not blocking, make a random move
        while (true) {
            int cellAI = getRandomNumbers().nextInt(0, 3);
            int columnAI = getRandomNumbers().nextInt(0, 3);

            if (gameTable[cellAI][columnAI] == '*') {
                gameTable[cellAI][columnAI] = 'O';
                System.out.println("AI has decided to make the following move: [" +
                        (cellAI + 1) + "][" + (columnAI + 1) + "].");
                break;
            }
        }
    }

    // Check if AI should block the player
    public static boolean shouldBlockPlayer(char[][] gameTable) {
        Random random = getRandomNumbers();

        if (random.nextInt(100) < 35) { // 35% chance to block
            for (int i = 0; i < 3; i++) {
                // Check rows and columns
                if (checkAndBlock(gameTable, i, 0, i, 1, i, 2) || checkAndBlock(gameTable,
                        0, i, 1, i, 2, i)) {
                    return true;
                }
            }
            // Check diagonals
            if (checkAndBlock(gameTable, 0, 0, 1, 1, 2, 2) || checkAndBlock(gameTable,
                    0, 2, 1, 1, 2, 0)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkAndBlock(char[][] gameTable, int r1, int c1, int r2, int c2, int r3, int c3) {
        if (gameTable[r1][c1] == 'X' && gameTable[r2][c2] == 'X' && gameTable[r3][c3] == '*') {
            gameTable[r3][c3] = 'O'; // Block the player
            System.out.println("AI blocks the player at: [" + (r3 + 1) + "][" + (c3 + 1) + "]");
            return true;
        }
        return false;
    }

    // Check game status
    public static boolean checkStatus(char[][] gameTable) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (gameTable[i][0] == gameTable[i][1] && gameTable[i][1] == gameTable[i][2] && gameTable[i][0] != '*') {
                printResult(gameTable[i][0]);
                return true;
            }

            if (gameTable[0][i] == gameTable[1][i] && gameTable[1][i] == gameTable[2][i] && gameTable[0][i] != '*') {
                printResult(gameTable[0][i]);
                return true;
            }
        }
        // Check diagonals
        if (gameTable[0][0] == gameTable[1][1] && gameTable[1][1] == gameTable[2][2] && gameTable[0][0] != '*') {
            printResult(gameTable[0][0]);
            return true;
        }

        if (gameTable[0][2] == gameTable[1][1] && gameTable[1][1] == gameTable[2][0] && gameTable[0][2] != '*') {
            printResult(gameTable[0][2]);
            return true;
        }

        // Check for draw
        boolean isDraw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable[i][j] == '*') {
                    isDraw = false;
                    break;
                }
            }
            if (!isDraw) break;
        }

        if (isDraw) {
            printResult('D'); // Pass 'D' for draw
            return true;
        }

        return false;
    }

    public static void printResult(char winner) {
        if (winner == 'X') {
            System.out.println("\u001B[33m");
            System.out.println("--------------------");
            System.out.println("\t" + player1Name + " WINS!");
            System.out.println("--------------------");
            System.out.println("\u001B[0m");
        } else if (winner == 'O') {
            System.out.println("\u001B[31m");
            System.out.println("--------------------");
            System.out.println("\t" + player2Name + " WINS!");
            System.out.println("--------------------");
            System.out.println("\u001B[0m");
        } else if (winner == 'D') {
            System.out.println("-------------------");
            System.out.println("\tIT'S A DRAW");
            System.out.println("-------------------");
        }
    }

    public static Random getRandomNumbers() {
        return new Random();
    }

    public static Scanner getInputValue() {
        return new Scanner(System.in);
    }
}