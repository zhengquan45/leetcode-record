package leetcode.editor.sort;

public class BubbleSort {

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    public static void sort(int[] nums) {
        int n = nums.length;
        //遍历n遍
        for (int i = 0; i < n; i++) {
            //直观感受就是每一次遍历都把最大的数放在末尾
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    SortTestHelper.swap(nums, j, j + 1);
                }
            }
        }
    }
}
