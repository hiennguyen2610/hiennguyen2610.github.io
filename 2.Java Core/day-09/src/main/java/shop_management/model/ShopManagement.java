package shop_management.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ShopManagement {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private int price;
}
