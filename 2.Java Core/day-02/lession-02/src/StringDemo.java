public class StringDemo {
    public static void main(String[] args) {
//            Khai báo kiểu literal
        String name = "Quang Hiển";
        String name1 = "Quang Hiển";

//            Khai báo kiểu Object (new)
        String email = new String("quanghien485@gmail.com");
        String email1 = new String("quanghien485@gmail.com");

        System.out.println("name : " + name);
        System.out.println("email : " + email);

//            So sánh chuỗi
//            == so sánh về địa chỉ ô nhớ (thường được áp dụng với primative type: kiểu dữ liệu nguyên thủy)
        System.out.println(name == name1);   // true
        System.out.println(email == email1); // false

//        Phương thức String
        String text = "Xin chào các bạn";
        System.out.println("In hoa: " + text.toUpperCase());
        System.out.println("In thường: " + text.toLowerCase());
        System.out.println("Độ dài: " + text.length());
        System.out.println("Cắt chuỗi: " + text.substring(0, 8));
        System.out.println("Vị trí 10 là kí tự: " + text.charAt(9));
        System.out.println("So sánh: " + text.equals("Xin chào các bạnn"));  // false
        System.out.println("So sánh không phân biệt hoa thường: " + text.equalsIgnoreCase("xin Chào các bạn"));


    }
}
