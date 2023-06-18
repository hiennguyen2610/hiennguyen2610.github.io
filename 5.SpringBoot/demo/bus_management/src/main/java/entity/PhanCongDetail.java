package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class PhanCongDetail {

    private Tuyen tuyen;
    private int soLuot;

    public PhanCongDetail() {
    }

    public PhanCongDetail(Tuyen tuyen, int soLuot) {
        this.tuyen = tuyen;
        this.soLuot = soLuot;
    }
}
