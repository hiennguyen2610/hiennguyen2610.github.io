package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.InputMismatchException;
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
        int tongSoTietHoc;
        do {
            try {
                tongSoTietHoc = new Scanner(System.in).nextInt();
                if (tongSoTietHoc > 0) {
                    this.total = tongSoTietHoc;
                    break;
                }
                System.out.print("Vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Vui lòng nhập lại: ");
            }
        } while (true);
        this.setTotal(new Scanner(System.in).nextInt());
        System.out.print("Nhập số tiết lý thuyết: ");
        this.setTheory(new Scanner(System.in).nextInt());
        System.out.print("Nhập mức kính phí: ");
        this.setExpense(new Scanner(System.in).nextFloat());

    }
}
