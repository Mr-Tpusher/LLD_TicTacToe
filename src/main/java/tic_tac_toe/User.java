package tic_tac_toe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class User {
    private String userName;
    private UUID userId;

    public User(String userName) {
        this.userName = userName;
        this.userId = UUID.randomUUID();
    }
}
