package entity;

import constant.Level;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Scanner;

@Getter
@Setter
@ToString
public class Teacher extends Person{

    private static int AUTO_ID = 100;
    private Level level;
    
    @Override
    public void inputInfo() {
        super.inputInfo();
        this.setId(Teacher.AUTO_ID++);
        this.inputLevel();
    }

    private void inputLevel() {
        System.out.println("1. Giáo sư - Tiến sĩ");
        System.out.println("2. Phó Giáo sư - Tiến sĩ");
        System.out.println("3. Giảng viên chính");
        System.out.println("4. Thạc sĩ");

        int selectLevel = 0;
        do {
            selectLevel = new Scanner(System.in).nextInt();
            if (selectLevel >= 1 && selectLevel <= 4) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        switch (selectLevel) {
            case 1:
                this.setLevel(Level.GS_TS);
                break;
            case 2:
                this.setLevel(Level.PGS_TS);
                break;
            case 3:
                this.setLevel(Level.GV);
                break;
            case 4:
                this.setLevel(Level.TS);
                break;
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
