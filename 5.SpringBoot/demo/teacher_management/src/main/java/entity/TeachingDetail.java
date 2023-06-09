package entity;

import lombok.*;

@Getter
@Setter
@ToString

public class TeachingDetail {
    private Subject subject;
    private int numberOfClasses;

    public TeachingDetail(Subject subject, int numberOfClasses) {
        this.subject = subject;
        this.numberOfClasses = numberOfClasses;
    }

}
