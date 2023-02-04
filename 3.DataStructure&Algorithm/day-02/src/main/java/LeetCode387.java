public class LeetCode387 {
    public int firstUniqChar(String s) {
        int[] alphabet = new int['z' - 'a' + 1];
        // bắt đầu từ 'a' -> index = 0 -> 'a' - 'a'
        // index c : 'c' - 'a' = 2
        // kết thúc tại 'z' -> index = 25
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            alphabet[cha-'a']++;  // cha - 'a' -. index tương ứng với character
        }  // đếm được số lần xuất hiện của tất cả kí tự trong s
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            if (alphabet[cha - 'a'] ==1 ) {
                return i;
            }
        }
        return -1;
    }
}
