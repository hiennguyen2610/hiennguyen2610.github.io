package shop_management.repository;

import shop_management.database.ProductDatabase;
import shop_management.model.ShopManagement;

import java.util.ArrayList;

public class ShopRepository {

    // Hiển thị danh sách sản phẩm
    public ArrayList<ShopManagement> showAll() {
        return ProductDatabase.shopManagements;
    }

    // Tìm kiếm sản phẩm theo tên
    public ArrayList<ShopManagement> findByName(String name) {
        ArrayList<ShopManagement> arrayList = new ArrayList<>();
        for (ShopManagement e:
             ProductDatabase.shopManagements) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    // Tìm sản phẩm theo ID
    public void findById(int id) {
        for (ShopManagement e :
                ProductDatabase.shopManagements) {
            if (e.getId() == id) {
                System.out.println(e);
            }
        }

        ArrayList<ShopManagement> arrayList = new ArrayList<>();
        for (ShopManagement e :
                ProductDatabase.shopManagements) {
            if (e.getId() != id) {
                arrayList.add(e);
            }
        }
        System.out.println("Danh sách sản phẩm còn lại: ");
        System.out.println(arrayList);
    }
}
