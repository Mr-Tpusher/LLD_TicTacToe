package tic_tac_toe;

import java.util.Random;

public class CompLevelEasy implements ICompLevelStrategy {
    private static final Random random = new Random();

    @Override
    public int makeMove(Board board) {
        int totalCells = board.getSize() * board.getSize();

        int move = random.nextInt(totalCells) + 1;
        while (!board.isCellAvailable(move))
            move = random.nextInt(totalCells) + 1;

        return move;
    }
}
