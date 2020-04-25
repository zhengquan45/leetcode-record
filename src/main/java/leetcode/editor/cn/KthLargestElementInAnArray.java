//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


package leetcode.editor.cn;


public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int kthLargest = solution.findKthLargest(nums, k);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            int l = 0, r = n - 1;
            int targetIndex = n - k;//第k大的元素应该在targetIndex索引上 比如 第2大的元素 应该排在n-2的位置上
            while (true) {
                int p = partition(nums, l, r);//partition 可以得出一个数应该在什么索引上 这里 p这个索引位置的nums[p]已经在合适位置了
                if (p == targetIndex) {
                    return nums[p];
                } else if (p > targetIndex) {//[l...targetIndex...p...r] [l....p-1]
                    r = p - 1;
                } else if (p < targetIndex) {//[l...p...targetIndex...r] [p+1...r]
                    l = p + 1;
                }
            }
        }

        private int partition(int[] nums, int l, int r) {
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

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}