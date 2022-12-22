package shop_management.database;

import shop_management.model.ShopManagement;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    public static ArrayList<ShopManagement> shopManagements = new ArrayList<>(List.of(
            new ShopManagement(1, "Bánh Dasani", "Thực phẩm", 20, 130_000),
            new ShopManagement(2, "Bánh Karo", "Thực phẩm", 16, 60_000),
            new ShopManagement(3, "Kẹo sữa", "Thực phẩm", 44, 20_000),
            new ShopManagement(4, "Chậu rửa", "Đồ gia dụng", 22, 30_000),
            new ShopManagement(5, "Khăn tắm", "Đồ gia dụng", 5, 100_000),
            new ShopManagement(6, "Muối", "Nhu yếu phẩm", 50, 28_000)
    ));
}
