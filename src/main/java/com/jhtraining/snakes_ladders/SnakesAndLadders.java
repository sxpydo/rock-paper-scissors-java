package com.jhtraining.snakes_ladders;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakesAndLadders {
    public static void main(String[] args) {
        Snake_n_Ladder snakeLadder = new Snake_n_Ladder();
        snakeLadder.startGame();
    }
}
class Snake_n_Ladder {
    final static int WINPOINT = 100;
    static Map<Integer, Integer> snake = new HashMap<>();
    static Map<Integer, Integer> ladder = new HashMap<>();
    {
        snake.put(92, 54);
        snake.put(70, 55);
        snake.put(43, 42);
        snake.put(29, 2);
        snake.put(95, 72);

        ladder.put(12, 25);
        ladder.put(11, 40);
        ladder.put(60, 85);
        ladder.put(46, 90);
        ladder.put(17, 69);
    }

    //this method will generate random number from 1-6
    public int rollDice() {
        int n = 0;
        Random r = new Random();
        n = r.nextInt(6) + 1;
        return n;
    }

    /*calculatePlayerValue() method will calculate
     * the position of the player based on his current
     * position after rolling the dice.
     */
    public int calculatePlayerScore(int playerPosition, int diceValue) {
        int player=playerPosition+diceValue;

        if (player > WINPOINT)
            return player;

        if (null !=snake.get(player)) {
            System.out.println("Oops! You have defeated by the snake!");
            player=snake.get(player);
        }

        if (null !=ladder.get(player)) {
            System.out.println("Climbing up the ladder...");
            player=ladder.get(player);
        }

        return player;
    }

    public boolean isWin(int playerPosition) {
        return WINPOINT<=playerPosition;
    }

    public void startGame() {
        int player1Position=0, player2Position=0;
        int currentPlayer=1;
        Scanner scanner= new Scanner(System.in);
        String rPressed;
        int diceValue = 0;
        do {
            System.out.println(currentPlayer == 1
                    ? "\n\nFirst player's turn" : "\n\nSecond player's turn");
            System.out.println("Press 'r' to roll Dice :)");
            rPressed=scanner.next();
            diceValue=rollDice();

            if (currentPlayer==1) {
                player1Position=calculatePlayerScore(player1Position, diceValue);
                System.out.println("Player 1 Position:"+player1Position);
                System.out.println("Player 2 Position:"+player2Position);
                System.out.println("-------------------------");
                if (isWin(player1Position)) {
                    System.out.println("Congratulations Player 1, you won the game!");
                    return;
                }
            } else {
                player2Position = calculatePlayerScore(player2Position, diceValue);
                System.out.println("Player 1  Position:"+player1Position);
                System.out.println("Player 2  Position:"+player2Position);
                System.out.println("-------------------------");
                if (isWin(player2Position)) {
                    System.out.println("Congratulations Player 2, you won the game!");
                    return;
                }
            }
            currentPlayer = -currentPlayer;
        } while ("r".equals(rPressed));
    }
}