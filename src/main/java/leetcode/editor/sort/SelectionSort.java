package leetcode.editor.sort;

import static leetcode.editor.sort.SortTestHelper.swap;

public class SelectionSort {

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    public static void sort(int[] nums) {
        int n = nums.length;
        //在[i,n)之间寻找最小的数
        for (int i = 0; i < n - 1; i++) {//小小的优化 https://coding.imooc.com/learn/questiondetail/72208.html
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {//小小的优化 https://coding.imooc.com/learn/questiondetail/145259.html
                swap(nums, i, minIndex);
            }
        }
    }
}
