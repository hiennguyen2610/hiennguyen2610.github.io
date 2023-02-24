// Phân tích đề bài:
// Xóa 1 phần tử trong 1 danh sách liên kết rồi trả về các phần tử còn lại đúng thứ tự

// Ý tưởng thực hiện:
// tạo 1 con trỏ current trỏ đến head và kiểm tra xem nó bằng với value ko
// sau đó dùng while duyệt danh sách và kiểm tra note kế tiếp xem có bằng value ko

// Độ phức tạp thuật toán: O(Fn) = O(n)

public class LeetCode202{
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;  // tạo con trỏ chỉ tới head

        // dùng while kiểm tra xem note đầu tiên bằng value ko
        while (head != null && head.val == val) {
            // nếu head = val thì cập nhật head thành note tiếp theo
            head = head.next;
        }

        // sau đó kiểm tra từ note thứ 2
        while (current != null && current.next != null) {  // nếu là null thì dừng vòng lặp
           // kiểm tra giá trị note tiếp theo
            if (current.next.val == val) {  // nếu gtri note tiếp theo bằng val
                current.next = current.next.next;  // thì sẽ bỏ qua nó và gán con trỏ vào note tiếp theo nữa
            } else {
                current = current.next;
            }
        }
        // Trả về head
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
