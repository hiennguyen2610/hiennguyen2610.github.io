package interface_demo;
import lombok.*;

@ToString
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

public class Square implements IShape {
    private double size;

    @Override
    public double getArea() {
        return this.size * this.size;
    }

    @Override
    public double getPerimeter() {
        return this.size * 4;
    }
}
