package interface_demo;

import lombok.*;

@ToString
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

public class Rectangle implements IShape, IOther{
    private double width;
    private double height;

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    @Override
    public void showInfo() {
        System.out.println();
    }
}


