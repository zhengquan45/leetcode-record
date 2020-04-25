package leetcode.editor.sort;

import static leetcode.editor.sort.SortTestHelper.swap;

public class QuickSort3Way {

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int l, int r) {

        //随机选择标定点来使得快速排序不会因为一个近乎有序数组退化多 O(N^2)的排序
        if (l >= r) {
            return;
        }
        //partition
        //随机选择标定点来使得快速排序不会因为一个近乎有序数组退化多 O(N^2)的排序
        int random = (int) (Math.random() * (r - l + 1) + l);
        swap(nums, l, random);
        int v = nums[l];

        //nums[l+1...lt]<v nums[lt+1,i-1]==v nums[gt...r]>v
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (nums[i] < v) {
                swap(nums, ++lt, i++);
            } else if (nums[i] > v) {
                swap(nums, i, --gt);
            } else {
                i++;
            }
        }
        swap(nums, lt, l);
        quickSort(nums, l, lt - 1);
        quickSort(nums, gt, r);
    }

}
