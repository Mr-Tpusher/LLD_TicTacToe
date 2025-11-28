package tic_tac_toe;

import lombok.Getter;
import lombok.Setter;
import tic_tac_toe.constants.SYMBOL;

import java.util.Scanner;

@Getter
@Setter
public class HumanPlayer extends Player {
    private User user;
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(User user, SYMBOL symbol) {
        super(symbol);
        this.user = user;
        super.setName(user.getUserName());
    }

    @Override
    public int makeMove(Board board) {
        System.out.println(this.getUser().getUserName() +
                "(" + super.getSymbol() + ") your turn," );

        int cell;
        do {
            System.out.println("Enter cell number:");
            cell = scanner.nextInt();
        } while (!board.isCellAvailable(cell));

        return cell;
    }

}
