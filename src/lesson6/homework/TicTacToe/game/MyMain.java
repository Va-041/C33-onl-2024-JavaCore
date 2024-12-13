package lesson6.homework.TicTacToe.game;

import java.util.Scanner;

public class MyMain {
    public static void main(String[] args){
        // new Game();
        startGame();
    }

    public static void startGame(){
        // Initial message
        getInitialMessage();

        // Input
        // Array
        char[][] table = createInitializeTable();

        // Test my table for game
        drawTable(table);
    }

    public static void getInitialMessage(){
        System.out.println("Welcome to TIC-TAC-TOE Game...");
        System.out.println("The rules are...");
    }

    public static char[][] createInitializeTable(){
        return new char[][]{
                {'*', '*', '*'},
                {'*', '*', '*'},
                {'*', '*', '*'}
        };
    }

    public static void drawTable(char[][] table){
        for (char[] outer : table){
            for (char inner: outer){
                System.out.print(inner + "\t");
            }
            System.out.println();
        }
    }

    public static Scanner getScannerInput(){
        return new Scanner(System.in);
    }
}