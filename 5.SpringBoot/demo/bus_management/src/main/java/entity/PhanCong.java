package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class PhanCong {
    private LaiXe laiXe;
    private PhanCongDetail[] phanCongDetail;

    public PhanCong() {
    }

    public PhanCong(LaiXe laiXe, PhanCongDetail[] phanCongDetail) {
        this.laiXe = laiXe;
        this.phanCongDetail = phanCongDetail;
    }
}
