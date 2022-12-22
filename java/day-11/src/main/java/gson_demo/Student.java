package gson_demo;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private int id;
    private String name;
    private int age;
    private String email;
}
