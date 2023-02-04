public class LeetCode1816 {
    public static String truncateSentence(String s, int k) {
        String[] strings = new String[k];

        // tách chuỗi dựa trên khoảng trắng
        String[] strings1 = s.split(" ");
        for (int i = 0; i < k; i++) {
            strings[i] = strings1[i];
        }
        String s1 = String.join(" ",strings);
        return s1;
    }

    public static void main(String[] args) {
        String str = "Hôm nay trời đẹp quá";
        System.out.println(truncateSentence(String.valueOf(str),3));
    }
}
