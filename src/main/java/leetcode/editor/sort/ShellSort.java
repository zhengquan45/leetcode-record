package leetcode.editor.sort;

public class ShellSort {

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    public static void sort(int[] nums) {
        int n = nums.length;
        //分组+插入
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += gap) {
                int cp = nums[i];
                for (int j = i; j > 0; j -= gap) {
                    if (cp < nums[j - gap]) {
                        SortTestHelper.swap(nums, j, j - gap);
                    }
                }
            }
        }
    }
}
