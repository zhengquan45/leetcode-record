package leetcode.editor.sort;

import static leetcode.editor.sort.SortTestHelper.swap;

public class SelectionSort {

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    public static void sort(int[] nums) {
        int n = nums.length;
        //在[i,n)之间寻找最小的数
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }
}
