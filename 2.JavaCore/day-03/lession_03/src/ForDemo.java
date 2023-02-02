public class ForDemo {
    public static void main(String[] args) {
        // Thực hiện cv thức dậy lúc 5:00 trong vòng 30 ngày
        for (int day = 1; day <= 30; day = day + 1) {
            System.out.println("Ngày " + day + " thức dậy lúc 5h00");
        }

        // Thực hiện cv thức dậy lúc 5h00 trong vào 30 ngày vào các ngày lẻ
        for (int day = 1; day <= 30; day = day +1) {
            if (day % 2 == 1) {
                System.out.println("Ngày " + day + " thức dậy lúc 5h00");
            }
        }
        // Thực hiện cv thức dậy lúc 5h00 trong 30 ngày. Cách 7 ngày nghỉ 1 lần.
        for (int Day = 1; Day <= 30; Day = Day + 1) {
            if (Day % 7 == 0) {
                System.out.println("Nghỉ");
                continue;
            }
            System.out.println("Ngày " + Day + " thức dậy lúc 5h");
        }

        int totalMoney = 0;

        // Thực hiện tiết kiệm trong 10 ngày, mỗi ngày 100000
//        for (int day = 1; day <= 10; day++) {
//            totalMoney += 100000;
//        }
        System.out.println(totalMoney);
        // Thực hiện tiết kiệm trong 10 ngày, từ ngày 5 trở đi tiết kiệm đc 200k
        for (int day = 1; day <= 10; day++) {
            if (day >= 5) {
                totalMoney += 200000;
            } else {
                totalMoney += 100000;
            }
        }
        System.out.println(totalMoney);
    }
}
