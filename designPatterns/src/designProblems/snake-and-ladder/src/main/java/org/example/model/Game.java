package org.example.model;

import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import java.util.concurrent.ThreadLocalRandom;

import java.util.*;

@Getter
public class Game {
    private Dice dice;
    private final Board board;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    private final Queue<Player> players;
    private final int noOfSnakes;
    private final int noOfLadders;

    public Game(int noOfLadders, int noOfSnakes, int boardSize) {
        this.noOfLadders = noOfLadders;
        this.noOfSnakes = noOfSnakes;
        this.board = new Board(boardSize);
        this.players = new ArrayDeque<>();
        this.snakes = new ArrayList<>(noOfSnakes);
        this.ladders = new ArrayList<>(noOfLadders);
        this.dice = new Dice(1, 6, 2);
        initBoard();
    }

    private void initBoard() {
        Set<String> snakeLadderSet = new HashSet<>();
        for (int i = 0; i < noOfSnakes; i++) {
            while (true) {
                int snakeStart = ThreadLocalRandom.current().nextInt(board.getStart(), board.getSize());
                int snakeEnd = ThreadLocalRandom.current().nextInt(board.getStart(), board.getSize());
                if (snakeStart > snakeEnd) {
                    String startEndPair = String.valueOf(snakeStart) + snakeEnd;
                    if (!snakeLadderSet.contains(startEndPair)) {
                        Snake snake = new Snake(snakeStart, snakeEnd);
                        snakes.add(snake);
                        snakeLadderSet.add(startEndPair);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < noOfLadders; i++) {
            while (true) {
                int ladderStart = ThreadLocalRandom.current().nextInt(board.getStart(), board.getSize());
                int ladderEnd = ThreadLocalRandom.current().nextInt(board.getStart(), board.getSize());
                if (ladderStart < ladderEnd) {
                    String startEndPair = String.valueOf(ladderStart) + ladderEnd;
                    if (!snakeLadderSet.contains(startEndPair)) {
                        Ladder ladder = new Ladder(ladderStart, ladderEnd);
                        ladders.add(ladder);
                        snakeLadderSet.add(startEndPair);
                        break;
                    }
                }
            }
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void playGame() {
        while (true) {
            Player player = players.poll();
            int value = dice.roll();
            int newPosition = player.getPosition() + value;
            if (newPosition > board.getEnd()) {
                player.setPosition(player.getPosition());
                players.offer(player);
            } else {
                player.setPosition(getNewPosition(newPosition));
                if (player.getPosition() == board.getEnd()) {
                    player.setHasWon(true);
                    System.out.println("Player " + player.getName() + " has won the Game");
                } else {
                    System.out.println("Player " + player.getName() + " new position is " + player.getPosition());
                    players.offer(player);
                }
            }
            if(players.size()<2){
                break;
            }
        }
    }

    private int getNewPosition(int newPosition) {
        for (Snake snake : snakes) {
            if (snake.getHead() == newPosition) {
                System.out.println("snake bite");
                return snake.getTail();
            }
        }
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == newPosition) {
                System.out.println("climbs ladder");
                return ladder.getEnd();
            }
        }
        return newPosition;
    }


}
