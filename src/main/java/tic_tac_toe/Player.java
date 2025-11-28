package tic_tac_toe;

import lombok.*;
import tic_tac_toe.constants.SYMBOL;

@Getter
@Setter
@ToString
public abstract class Player {
    private String name;
    private SYMBOL symbol;

    public Player(SYMBOL symbol) {
        this.symbol = symbol;
    }

    public abstract int makeMove(Board board);
}
