package tic_tac_toe;

import tic_tac_toe.constants.SYMBOL;

public class Main {
    public static void main(String[] args) {
        int boardSize = 3;
        Player player1 = new HumanPlayer(new User("Turing"), SYMBOL.X);
        Player player2 = new Computer(new CompLevelEasy(), SYMBOL.O);

        Game game = new Game(boardSize, player1, player2);

        game.launch();
    }
}
