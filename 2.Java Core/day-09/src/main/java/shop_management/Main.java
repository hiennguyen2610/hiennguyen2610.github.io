package shop_management;

import shop_management.controller.ShopController;

public class Main {
    public static void main(String[] args) {
        ShopController shopController = new ShopController();
        shopController.run();
    }
}
