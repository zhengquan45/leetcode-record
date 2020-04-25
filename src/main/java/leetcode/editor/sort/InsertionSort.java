package leetcode.editor.sort;

public class InsertionSort {

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {

            // 寻找元素nums[i]合适的插入位置
//  写法1
//            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
//                swap(nums, j, j - 1);
//            }

            int e = nums[i];
            int j;
            for (j = i; j > 0 && nums[j - 1] > e; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = e;
        }
    }

    public static void sort(int[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            int e = arr[i];
            int j = i;
            for (; j > l && arr[j - 1] > e; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }
}
