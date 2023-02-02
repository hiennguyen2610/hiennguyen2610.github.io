public class IfDemo {
    public static void main(String[] args) {
        // Ví dụ
        // Thêm các toán từ && (và) , || (hoặc) , ! (phủ định)
        int hour = 13;
        if (hour < 12) {
            System.out.println("Good Morning");
        } else if (hour <= 18){
            System.out.println("Good Afternoon");
        } else {
            System.out.println("Good Evening");
        }

        // Kết hợp nhiều điều kiện
        boolean troiDep = true;
        boolean coTien = true;
        if (!troiDep && coTien)
            System.out.println("Đi chơi");

        if (troiDep || coTien) {
            System.out.println("Đi chơi");
        }

        // Toán tử 3 ngôi
        String message = troiDep && coTien ? "Đi chơi" : "Ở nhà";
        System.out.println(message);

        int number = -12;
        String text = number > 0 ? "Số dương" : number == 0 ? "Số không" : "Số âm";
        System.out.println(text);
    }
}
