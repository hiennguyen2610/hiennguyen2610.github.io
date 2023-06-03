package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Scanner;

@Setter
@Getter
@ToString
public class Tuyen implements Inputable {
    private static int AUTO_ID = 100;
    private int id;
    private int khoangCach;
    private int diemDung;

    public void nhapThongTin() {
        this.setId(Tuyen.AUTO_ID++);
        this.setKhoangCach(new Scanner(System.in).nextInt()); // Nhập khoảng cách
        System.out.print("Nhập số điểm dừng: ");
        this.setDiemDung(new Scanner(System.in).nextInt());
    }

    @Override
    public String toString() {
        return "Tuyen{" +
                "id=" + id +
                ", khoangCach=" + khoangCach +
                ", diemDung=" + diemDung +
                '}';
    }
}
