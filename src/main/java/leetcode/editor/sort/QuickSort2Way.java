package leetcode.editor.sort;

import static leetcode.editor.sort.SortTestHelper.swap;

public class QuickSort2Way {

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int l, int r) {

        //随机选择标定点来使得快速排序不会因为一个近乎有序数组退化多 O(N^2)的排序
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
        int i = l + 1, j = r; //nums[l+1..i-1]<=v nums[j+1...r]>=v
        while (true) {
            while (i <= r && nums[i] < v) {
                i++;
            }
            while (j >= l + 1 && nums[j] > v) {
                j--;
            }
            if (i > j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, j, l);
        return j;
    }
}
