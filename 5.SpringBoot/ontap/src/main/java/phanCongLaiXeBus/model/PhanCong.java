package phanCongLaiXeBus.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
public class PhanCong {
    private LaiXe laiXe;
    private List<Tuyen> danhSachTuyen;
    private int soLuot;
}
