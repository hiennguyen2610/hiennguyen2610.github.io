// Phân tích đề bài:
// So sánh 2 chuỗi bất kì sau khi xóa kí tự # và chữ đứng trước nó
// Ví dụ: s = "ab#c", t = "ad#c" -> xóa đi b# và d# -> true
// s = "ab##", t = "c#d#" -> xóa đi ab và cd -> true

// Ý tưởng thực hiện:
// Tạo 2 stack để chứa kết quả của 2 chuỗi sau khi thực thi
// Duyệt 2 chuỗi, nếu kí tự đang xét ko phải là kí tự # thì ta thêm kí tự đó vào stack tương ứng
// nếu kí tự đó là # thì ta xóa phần tử đầu tiên của stack
// sau đó kiểm tra điều kiện:
// nếu kích thước 2 stack khác nhau --> trả về false vì k giống nhau
// nếu phần tử đầu tiên của 2 stack khác nhau --> trả về false
// nếu cả 2 stack đều rỗng hoặc phần tử giống nhau thì return true

// Độ phức tạp thuật toán: Fn = n +n +n = 3n -> O(n)

import java.util.Stack;

public class LeetCode844 {
    public boolean backspaceCompare(String s, String t) {
        // tạo stack
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        // Duyệt chuỗi s
        for (int i = 0; i < s.length(); i++) {
            // Nếu kí tự đang xét ko phải là # thì thêm vào stack
            if (s.charAt(i) != '#') {
                sStack.push(s.charAt(i));
            } else if (!sStack.isEmpty()) {
                // nếu là kí tự # và stack ko rỗng thì xóa phần tử đầu của stack
                sStack.pop();
            }
        }

        // Duyệt chuỗi t
        for (int i = 0; i < t.length(); i++) {
            // Nếu kí tự đang xét ko phải là # thì thêm vào stack
            if (t.charAt(i) != '#') {
                tStack.push(t.charAt(i));
            } else if (!tStack.isEmpty()) {
                // nếu là kí tự # và stack ko rỗng thì xóa phần tử đầu của stack
                tStack.pop();
            }
        }

        // So sánh 2 stack
        if (sStack.size() != tStack.size()) {
            // nếu kích thước 2 stack khác nhau
            // trả về false
            return false;
        }
        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) {
                // nếu 2 stack đều ko rỗng và phần tử đầu tiên của 2 stack khác nhau
                // thì trả về false
                return false;
            }
        }

        // Trả về trường hợp còn lại
        return true;
    }
}
