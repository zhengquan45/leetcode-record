package leetcode.editor.sort;

import static leetcode.editor.sort.SortTestHelper.swap;

public class HeapSort {

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    public static void sort(int[] nums) {
        int n = nums.length;
        //heapify
        for (int i = (n - 2) / 2; i >= 0; i--) {
            shiftDown(nums, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            shiftDown(nums, i, 0);
        }
    }

    private static void shiftDown(int[] nums, int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;//左节点 默认最大的是左节点
            if (j + 1 <= n && nums[j + 1] > nums[j]) {
                //存在右节点且大于左节点 最大设置为右节点
                j++;
            }
            if (nums[k] >= nums[j]) {
                break;
            }
            swap(nums, j, k);
            k = j;
        }
    }
}
