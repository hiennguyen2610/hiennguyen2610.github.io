package entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Teaching {
    private Teacher teacher;
    private TeachingDetail[] teachingDetails;
}
