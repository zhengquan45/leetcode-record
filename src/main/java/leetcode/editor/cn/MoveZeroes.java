//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        Solution solution = new MoveZeroes().new Solution();
        solution.moveZeroes(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    //时间复杂度 O(n)
    //空间复杂度 O(1)
    class Solution {
        public void moveZeroes(int[] nums) {
            int k = 0; // nums中[0,k)的元素均为非0元素
            //遍历到第i个元素后 保证[0,i]中所有非0元素
            //都按照顺序排列在[0...k)中
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if(i != k) {
                        int temp = nums[k];
                        nums[k] = nums[i];
                        nums[i] = temp;
                    }
                    k++;
                }
            }
        }
    }

    //main.java.leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        //时间复杂度 O(n)
        //空间复杂度 O(n)
        public void moveZeroes(int[] nums) {
            List<Integer> nonZeroElements = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nonZeroElements.add(nums[i]);
                }
            }
            for (int i = 0; i < nonZeroElements.size(); i++) {
                nums[i] = nonZeroElements.get(i);
            }

            for (int i = nonZeroElements.size(); i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    class Solution2 {
        public void moveZeroes(int[] nums) {
            int k = 0; // nums中[0,k)的元素均为非0元素
            //遍历到第i个元素后 保证[0,i]中所有非0元素
            //都按照顺序排列在[0...k)中
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            for (int i = k; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}