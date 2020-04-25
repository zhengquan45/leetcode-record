//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。 
//
// 示例: 
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
// 
//
// 进阶: 
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// Related Topics 数组 双指针 二分查找


package leetcode.editor.cn;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 2, 4, 3};
        int s = 7;
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        int i = solution.minSubArrayLen(s, ints);
        assert i == 2;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int sum = 0, l = 0, r = -1;//[l...r]为滑动窗口
            int len = nums.length + 1;
            while (l < nums.length) {
                if (r + 1 < nums.length && sum < s) {
                    sum += nums[++r];//这里因为r先加了 再放在数组索引中 需要注意 越界判断
                } else {
                    sum -= nums[l++];
                }
                if (sum >= s) {
                    len = Math.min(len, r - l + 1);
                }
            }
            if (len == nums.length + 1) len = 0;
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public int minSubArrayLen(int s, int[] nums) {
            //[i...j]子数组
            int len = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum >= s) {
                        len = Math.min(len, j - i + 1);
                        break;
                    }
                }
            }
            len = len == Integer.MAX_VALUE ? 0 : len;
            return len;
        }
    }
}