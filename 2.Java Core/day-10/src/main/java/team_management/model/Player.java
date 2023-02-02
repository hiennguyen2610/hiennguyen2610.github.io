package team_management.model;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor


public class Player {
    private int number;
    private String name;
    private Position position;
}
