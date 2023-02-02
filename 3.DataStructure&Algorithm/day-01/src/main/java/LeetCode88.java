public class LeetCode88 {
    public void merge(int[] nums1, int[] nums2, int m, int n) {
        // m: độ dài của dãy nums1
        // n: độ dài của dãy nums2
        // tìm vị trí cần insert
        int lengthOfNums1 = m;
        int lengthOfNums2 = n;
        for (int i = 0; i < nums2.length; i++) { // lấy ra phần tử trong nums2
            // tìm vị trí cần insert
            // chính là vị trí cua phần tử đấu tiên > nums2[i]
            for (int j = 0; j < m; j++) {
                if (nums2[i] < nums1[j]) {
                    insert(j, nums2[i], lengthOfNums1, nums1);
                    lengthOfNums1++;
                    lengthOfNums2--;
                    break;
                }
            }
        }
        if (lengthOfNums2 > 0) {
            int index = m + n - lengthOfNums2;
            while (index < m + n)   {
                nums1[index] = nums2[n - lengthOfNums2];
                index++;
                lengthOfNums2--;
            }
        }
    }

    private void insert(int index, int number, int lengthOfNums1, int[] arr) {
        for (int i = lengthOfNums1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] =  number;
    }
}
