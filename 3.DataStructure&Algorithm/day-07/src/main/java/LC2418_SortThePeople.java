// Yêu cầu đề bài:
// Cho 2 mảng bao gồm tên và chiều cao, sắp xếp lại mảng tên
// theo thứ tự chiều cao từ lớn tới nhỏ
// Ví dụ: names = ["A", "B", "C"] , heights = [180, 160, 170]
// Sắp xếp lại sẽ là newNames = ["A", "C", "B"]

// ý tưởng thực hiện:
// Sử dụng bubble sort để so sánh chiều cao của 2 người qua index của mảng
// nếu người có chỉ số sau có chiều cao lớn hơn người trước thì hoán đổi vị trí 2 chỉ số
// sau khi sắp xếp xong tạo mảng mới chứa tên của người đã đc sắp xếp và trả về nó.

import java.util.Arrays;

public class LC2418_SortThePeople {
    public static String[] sortPeople(String[] names, int[] heights) {

        // Tạo biến đếm bằng chiều dài của mảng:
        int count = heights.length;

        // Tạo 1 mảng để lưu chỉ số các phần tử trong mảng names:
        int[] arr = new int[count];

        // Chạy for gán mỗi phần tử của mảng arr giá trị là chỉ số của phần tử đó
        for (int i = 0; i < count; i++) {
            arr[i] = i;
        }

        // Sử dụng bubble sort để sắp xếp mảng theo chiều cao giảm dần
        for (int i = 0; i < count-1; i++) {
            for (int j = i+1; j < count; j++) { // j=i+1 để so sánh index đứng ngay sau i
                if (heights[arr[i]] < heights[arr[j]]) {
                    // Gán index tại i với temp để hoán đổi vị trí
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Tạo mảng mới để lưu tên đã đc sắp xếp
        String[] newName = new String[count];
        for (int i = 0; i < count; i++) {
            newName[i] = names[arr[i]];
        }

        // Trả về kq
        return newName;
    }

    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        sortPeople(names,heights);
        System.out.println(Arrays.toString(sortPeople(names,heights)));
    }
}
