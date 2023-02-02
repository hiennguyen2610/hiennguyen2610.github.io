public class MethodDemo {
    public static void main(String[] args) {
        // Công việc A: Tốn mất 20 dòng code
        // Thực hiện công việc A 10 lần: Tốn mất 200 dòng code
        // Có Method : tốn thêm 10 dòng để gọi


        int data =  sumNumber(3, 4);
        System.out.println(data);

        System.out.println(sumNumber(10, 30));
        sayHello();

        MethodDemo methodDemo = new MethodDemo();


    }

        // Tính tổng 2 số: Trả về kq là tổng 2 số đấy
        // Tham số: Parameter (giá trị ảo chưa biết trước)
        // Đối số: argument (giá trị thật khi thực thi method)
    public static int sumNumber(int a, int b) {
        return a + b;
        // int: phương thức có giá trị trả về
    }

    public static void sayHello() {
        System.out.println("Xin chào");
        // void: phương thức này ko trả về giá trị gì cả


    }

}
