package lesson6.homework.TicTacToe.game;

import java.util.Random;
import java.util.Scanner;

/**
 * @author TicTacoToe Game by TMS
 * <p>1. Make introduction message about the game;</p>
 * <p>2. Draw the table;</p>
 * <p>3. Decided who plays the first;</p>
 * <p>4. Make a move: player OR AI;</p>
 * <p>5. Check whether someone WON;</p>
 * <p>6. If the player wins -> YOU HAVE WON! WOULD YOU LIKE TO PLAY AGAIN?</p>
 * <p>7. If the AI wins -> YOU HAVE LOST! AI HAS WON! WOULD YOU LIKE TO PLAY AGAIN?</p>
 * <p>8. If there is a draw -> IT IS A DRAW. WOULD YOU LIKE TO PLAY AGAIN?</p>
 * <p>9. If 'n' -> GOODBYE!</p>
 * <p>9.1. If 'y' -> New Game.</p>
 */
public class TicTacToeGame {
    public static void main(String[] args){
        startGame();
    }

    // Starts the game
    public static void startGame(){
        getInitialMessage();

        if ((getInputValue().nextLine()).equals("y")){
            System.out.println("----------------------------------------------------------------------------------------");
            // Create a matrix 3x3
            char[][] gameTable = createInitializeTable();
            drawTable(gameTable);

            // Through a dice
            int dice = getRandomNumbers().nextInt(0, 21);

            // from 0 to 10 player
            if (dice >= 0 && dice <= 10){
                // Player makes the first move
                makePlayerMove();
            } else {
                // from 11 to 20
                makeAIMove();
            }
        } else {
            System.out.println("\u001B[31m\t" + "You have decided to leave the game. GOODBYE!" + "\u001B[0m");
        }

        // !!! 1. Создать возможность передачи заданных параметров, т.е. от ИИ и человек
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
    }

    // Create game's table
    public static char[][] createInitializeTable(){
        return new char[][]{
                {'*', '*', '*'},
                {'*', '*', '*'},
                {'*', '*', '*'}
        };
    }

    // Get initial message
    public static void getInitialMessage(){
        System.out.println("\u001B[34m\t");
        System.out.println("-------------------------------WELCOME TO TIC-TAC-TOE GAME------------------------------");
        System.out.println("This is the instruction:");
        System.out.println("\tThe game will draw a table.");
        System.out.println("\tAfter it decides who starts the first.");
        System.out.println("\tIf a player starts the game - X.");
        System.out.println("\tIf a AI starts the game, the player will use - O.");
        System.out.print("Would you like to move on?! (y - Yes, the rest - No: " + "\u001B[0m");
    }

    // Draws the table
    public static void drawTable(char[][] gameTable){
        System.out.println("\u001B[32m");
        for(char[] outer : gameTable){
            for (char inner : outer){
                System.out.print("\t" + inner + "  ");
            }
            System.out.println();
        }
        System.out.println("\u001B[0m");
    }

    // Make AI move
    public static void makeAIMove(){
        // from 0 to 2 - cells
        // from 0 to 2 - columns
        // coordinates cellAI x columnAI
        int cellAI = getRandomNumbers().nextInt(0, 3);
        int columnAI = getRandomNumbers().nextInt(0, 3);

        System.out.println("AI has decided to make the following move: [" +
                (cellAI + 1) + "][" + (columnAI + 1) + "].");
    }

    // Make Player's move
    public static void makePlayerMove(){
        // We must check whether the player have entered a correct value from 1 to 3

        while(true){
            System.out.print("Please, enter coordinates cell (1-3): ");
            int cellPlayer = getInputValue().nextInt();
            System.out.print("Please, enter coordinates column (1-3): ");
            int columnPlayer = getInputValue().nextInt();

            if (cellPlayer >= 1 && cellPlayer <= 3 && columnPlayer >=1 && columnPlayer <= 3){
                System.out.println("The player have decided to put a value: [" +
                        cellPlayer + "][" + columnPlayer + "].");
                break;
            }
            System.out.println("\u001B[31m\t");
            System.out.println("YOU HAVE ENTERED A WRONG VALUE. PLEASE, CHECK ACCESSIBLE COORDINATES AND RE-ENTER.");
            System.out.println("\u001B[0m");
        }
    }

    // Check game status
    public static void checkStatus(){
        //
    }

    // Get random numbers
    public static Random getRandomNumbers(){
        return new Random();
    }

    // Get input
    public static Scanner getInputValue(){
        return new Scanner(System.in);
    }
}
