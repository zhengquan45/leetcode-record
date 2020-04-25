package leetcode.editor.sort;

import static leetcode.editor.sort.SortTestHelper.swap;

public class QuickSort {

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int l, int r) {

        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    //对nums [l..r]部分进行partition操作
    //返回p 使得[l..p-1] < nums[p] [p+1...r] > nums[p]
    private static int partition(int[] nums, int l, int r) {
        //随机选择标定点来使得快速排序不会因为一个近乎有序数组退化多 O(N^2)的排序
        int random = (int) (Math.random() * (r - l + 1) + l);
        swap(nums, l, random);
        int v = nums[l];
        int j = l;//<v数集合的尾指针 这时这个集合一个元素都没有j=l
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < v) {
                swap(nums, ++j, i);
            }
        }
        swap(nums, l, j);
        return j;
    }
}
