public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,9,22,63,100};
        System.out.println(binarySearch(arr,22));
        System.out.println(binarySearch2(arr,22,0, arr.length));
    }

    // Sử dụng vòng lặp
    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        while (left<=right) {  // left = right -> mảng con chỉ chứa duy nhất 1 phần tử: arr[left] = a[mid] = a[right]
            int mid = (left+right)/2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                // range: mid + 1 -> right
                left = mid + 1;
            } else {
                // range: left > mid - 1
                right = mid - 1;
            }
        }
        // left > right:
        return -1;
    }

    // Sử dụng đệ quy
    public static int binarySearch2(int[] arr, int target, int left, int right) {
        // Điều kiện dừng
        if (left>right) {
            return -1;
        }
        // Công thức
        int mid = (left+right)/2;
        if (target == arr[mid]) {
            return mid;
        }
        if (target > arr[mid]) {
            return binarySearch2(arr,target,mid + 1, right);
        } else { // target < arr[mid]
            return binarySearch2(arr,target, left, mid-1);
        }
    }
}
