package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Scanner;

@Getter
@Setter
@ToString

public class Subject {

    public static int AUTO_ID = 100;

    private int id;
    private String name;
    private int total;
    private int theory;
    private float expense;

    public void inputInfo() {
        this.setId(Subject.AUTO_ID++);
        // Nhap ten mon hoc
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập tổng số tiết: ");
        this.setTotal(new Scanner(System.in).nextInt());
        System.out.print("Nhập số tiết lý thuyết: ");
        this.setTheory(new Scanner(System.in).nextInt());
        System.out.print("Nhập mức kính phí: ");
        this.setExpense(new Scanner(System.in).nextInt());

    }
}
