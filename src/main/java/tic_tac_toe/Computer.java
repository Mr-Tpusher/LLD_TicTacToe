package tic_tac_toe;

import lombok.Getter;
import lombok.Setter;
import tic_tac_toe.constants.SYMBOL;

@Getter
@Setter
public class Computer extends Player {
    private ICompLevelStrategy compLevel;

    public Computer(ICompLevelStrategy compLevel, SYMBOL symbol) {
        super(symbol);
        super.setName("Computer");
        this.compLevel = compLevel;
    }

    @Override
    public int makeMove(Board board) {
        return compLevel.makeMove(board);
    }
}
