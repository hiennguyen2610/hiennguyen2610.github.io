package entity;

import constant.TrinhDo;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter

public class Person implements Inputable {
    protected int id;
    protected String name;
    protected String address;
    protected String phone;

    public void nhapThongTin() {
        // Nhập tên lái xe
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập địa chỉ: ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.print("Nhập số điện thoại: ");
        this.setPhone(new Scanner(System.in).nextLine());
        System.out.println("Nhập trình độ lái xe, vui lòng chọn 1 trong các lựa chọn sau: ");
    }
}
