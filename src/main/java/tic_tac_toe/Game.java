package tic_tac_toe;

import tic_tac_toe.constants.GameState;

import java.util.ArrayDeque;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private GameState gameState;

    public Game(int size, Player player1, Player player2) {
        this.board = new Board(size);
        players = new ArrayDeque<>();
        players.offer(player1);
        players.offer(player2);
    }

    public void launch() {

        board.printBoard();

        while (gameState != GameState.FINISHED) {
            Player currPlayer = players.peek();

            int cell = currPlayer.makeMove(this.board);

            if (!board.isCellAvailable(cell)) {
                System.out.println("Cell is already occupied, try another cell.");
                continue;
            }

            board.markMove(cell, currPlayer);

            if (isWinner(currPlayer, cell)) {
                System.out.println("Congratulations!!!");
                System.out.println(currPlayer.getName() + " won!");
                gameState = GameState.FINISHED;
            }

            players.offer(players.poll());
        }


    }
    boolean isWinner(Player player, int cell) {
        return this.board.isWinner(player, cell);
    }
}
