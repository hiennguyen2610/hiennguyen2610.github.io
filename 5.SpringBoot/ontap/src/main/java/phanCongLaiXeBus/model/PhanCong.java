package phanCongLaiXeBus.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
public class PhanCong {
    private LaiXe laiXe;
    private Tuyen tuyen;
    private int soLuot;
}
