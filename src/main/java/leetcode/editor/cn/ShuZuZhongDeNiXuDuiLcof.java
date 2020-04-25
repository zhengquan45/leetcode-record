//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//


package leetcode.editor.cn;

public class ShuZuZhongDeNiXuDuiLcof {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7};
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        solution.reversePairs(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] nums) {
            int result = 0;
            int n = nums.length;
            for (int sz = 1; sz < n; sz = 2 * sz) { //归并的间距 从1开始 两倍递增 也就是纵向的层级
                for (int i = 0; i < n - sz; i += 2 * sz) {
                    result += merge(nums, i, i + sz - 1, Math.min(n - 1, i + 2 * sz - 1));
                }
            }
            return result;
        }

        private int merge(int[] arr, int l, int mid, int r) {
            int result = 0;
            int tempLen = r - l + 1;
            int[] temp = new int[tempLen];
            for (int i = l; i <= r; i++) {   // 把[l..r] 游标i 复制到temp[0...r-l] 游标i-l l是偏移量
                temp[i - l] = arr[i];
            }
            int i = l, j = mid + 1;
            for (int k = l; k <= r; k++) {
                if (i > mid) {// 说明[l...mid]都进入arr 把temp右边剩余的数即temp[j-l]继续循环j++ 到j>r
                    arr[k] = temp[j - l];
                    result = result + (mid - i);
                    j++;
                } else if (j > r) {// 说明[mid+1...r]都进入arr 把temp左边剩余的数即temp[i-l]继续循环i++ 到i>mid
                    arr[k] = temp[i - l];
                    i++;
                } else if (temp[i - l] < temp[j - l]) {
                    arr[k] = temp[i - l];
                    i++;
                } else {
                    arr[k] = temp[j - l];
                    result = result + (mid - i);
                    j++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}