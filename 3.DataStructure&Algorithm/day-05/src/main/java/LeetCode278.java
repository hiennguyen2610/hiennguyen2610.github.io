public class LeetCode278 {
    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start<end) {
            int mid = start + (end-start)/2;
            if (isBadVersion(mid)) {  // nếu kq là true thì tiếp tục kiểm tra với end = mid;
                end = mid;
            } else {
                start = mid + 1;   // nếu kq là false thì kiểm tra mảng bên phải với start = mid + 1
            }
        }
        return start;  // break vòng while trả về start = 1
    }

    private static boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
