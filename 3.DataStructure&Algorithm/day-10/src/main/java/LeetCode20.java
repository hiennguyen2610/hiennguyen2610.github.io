// Phân tích đề bài: cho 1 chuỗi bao gồm các kí tự đóng và mở ngoặc
// kiểm tra xem các cặp dấu có đủ không

// Ý tưởng thực hiện: lấy ra các kí tự trong chuỗi bằng vòng for
// và sử dụng stack để kiểm tra xem có hợp lệ không

// Độ phức tạp thuật toán: O(Fn)

import java.util.Stack;

public class LeetCode20 {
    public boolean isValid(String s) {
        // Khởi tạo thư viện Stack với lớp Character để lưu trữ kí tự
        Stack<Character> stack = new Stack<>();
        // Duyệt chuỗi
        for (int i = 0; i < s.length(); i++) {
            // lấy kí tự tại vị trí i trong chuỗi s và lưu vào biến char
            char w = s.charAt(i);

            // các điều kiện kiểm tra
            if (w == '(' || w == '[' || w == '{') {   // nếu w == ([{
                stack.push(w);  // thì thêm nó vào đầu dãy
            }
            // nếu trong chuỗi có các kí tự )]} thì kiểm tra xem đỉnh của dãy có
            // phải là các kí tự ([{ không, nếu có thì xóa nó đi
            else {
                // nếu có kí tự đóng và stack ko rỗng và kí tự đỉnh của stack là mở
                // thì ta xóa đi kí tự đỉnh đó
                if (w == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else if (w == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else if (w == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // nếu các cặp dấu đủ thì stack sẽ rỗng, kq trả về true;
        return stack.isEmpty();
    }
}
