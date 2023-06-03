package entity;

import constant.TrinhDo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Scanner;

@Getter
@Setter
@ToString
public class LaiXe extends Person {

    private static int AUTO_ID = 10000;
    private TrinhDo trinhDo;

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        this.setId(LaiXe.AUTO_ID++);
        this.nhapTrinhDo();
    }

    private void nhapTrinhDo() {
        System.out.println("1. Trình độ A");
        System.out.println("2. Trình độ B");
        System.out.println("3. Trình độ C");
        System.out.println("4. Trình độ D");
        System.out.println("5. Trình độ E");
        System.out.println("6. Trình độ F");

        int chonTrinhDo = 0;
        do {
            chonTrinhDo = new Scanner(System.in).nextInt();
            if (chonTrinhDo >= 1 && chonTrinhDo <= 6) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        switch (chonTrinhDo) {
            case 1:
                this.setTrinhDo(TrinhDo.A);
                break;
            case 2:
                this.setTrinhDo(TrinhDo.B);
                break;
            case 3:
                this.setTrinhDo(TrinhDo.C);
                break;
            case 4:
                this.setTrinhDo(TrinhDo.D);
                break;
            case 5:
                this.setTrinhDo(TrinhDo.E);
                break;
            case 6:
                this.setTrinhDo(TrinhDo.F);
                break;
        }
    }

    @Override
    public String toString() {
        return "LaiXe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", trinhDo=" + trinhDo +
                '}';
    }

}


