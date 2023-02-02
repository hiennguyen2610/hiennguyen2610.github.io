public class WhileDemo {
    public static void main(String[] args) {
//        for (int day = 1; day <= 30; day ++) {
//            System.out.println("Ngay" + day + " thuc day luc 5h");
//        }
//        int day = 1;
//        while (day <= 30) {
//            System.out.println("Ngay" + day + " thuc day luc 5h");
//            day ++;
//        }
        int day = 0;
        do {
            if (day % 2 == 0) {
                System.out.println("Ngay" + day + " thuc day luc 5h");
            } else {
                System.out.println("ngay" + day + " thuc day luc 6h");
            }
            day ++;
        } while (day < 30);
    }
}
