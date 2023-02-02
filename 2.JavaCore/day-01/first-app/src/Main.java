public class Main {
    public static void main(String[] args) {
        System.out.println("1111");

        // Khai bao bien
//        Khai báo các kiểu dữ liệu
        long salary = 1_000_000_000L;
        double height = 1.7;   //khai báo số có dấu phẩy
        float weight = 60.5f;

        System.out.println(salary);
        boolean isExist = true;
        boolean isMarried = false;

        char characterA = 'A';
        char characterB = 'B';

        System.out.println(characterA);
        System.out.println(characterB);

//        eép kiểu
        int number = 10;
        long numberOne = number;

        short numberTwo = (short) number;

        //phạm vi global: khai báo bên ngoài method
        String globalVar = "Global Variable";
        System.out.println(globalVar);

        {
            String blockVar = "block variable";
            System.out.println(blockVar);

    }
}



}

