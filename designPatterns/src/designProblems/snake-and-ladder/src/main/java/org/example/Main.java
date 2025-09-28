package org.example;

import org.example.model.Game;
import org.example.model.Player;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Board size : ");
        int boardSize = scanner.nextInt();
        System.out.println("Enter the Number of players :");
        int noOfPlayers = scanner.nextInt();
        System.out.println("Enter the number of ladders : ");
        int noOfLadders = scanner.nextInt();
        System.out.println("Enter the number of Snakes");
        int noOfSnakes = scanner.nextInt();

        Game game = new Game(noOfLadders, noOfSnakes, boardSize);
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter Player " + (int)(i + 1) + " Name ");
            String pName = scanner.next();
            Player player = new Player(pName);
            game.addPlayer(player);
        }
        game.playGame();
    }
}