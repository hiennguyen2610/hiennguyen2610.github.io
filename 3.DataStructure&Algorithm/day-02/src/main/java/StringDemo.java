public class StringDemo {
    public static void main(String[] args) {
        String str = "abc123";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(c + " ");
        }
    }
}
