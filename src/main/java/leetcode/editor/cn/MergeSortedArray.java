//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


package leetcode.editor.cn;


import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        Solution solution = new MergeSortedArray().new Solution();
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = 0, p2 = 0;
            int[] nums3 = new int[m];
            System.arraycopy(nums1, 0, nums3, 0, m);
            int p = 0;
            while (p1 < m && p2 < n) {
                if (nums2[p2] > nums3[p1]) {
                    nums1[p++] = nums3[p1++];
                } else {
                    nums1[p++] = nums2[p2++];
                }
            }
            if (p1 < m) {
                System.arraycopy(nums3, p1, nums1, p1 + p2, m - p1);
            }
            if (p2 < n) {
                System.arraycopy(nums2, p2, nums1, p1 + p2, n - p2);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1);
        }
    }
}