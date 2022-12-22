package shop_management.service;

import shop_management.model.ShopManagement;
import shop_management.repository.ShopRepository;

public class ShopService {
    public ShopRepository shopRepository = new ShopRepository();
    public void seeAll() {
        for (ShopManagement e : shopRepository.showAll()) {
            System.out.println(e);
        }
    }
    public void findByName(String name){
        for (ShopManagement e:shopRepository.findByName(name)) {
            System.out.println(e);
        }
    }
    public void findById(int id){
        shopRepository.findById(id);
    }
}
