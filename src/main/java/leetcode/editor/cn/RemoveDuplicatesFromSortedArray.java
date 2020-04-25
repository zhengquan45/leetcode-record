//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2};
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        solution.removeDuplicates(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    //怎么定义删除 数组中去除 还是放在数组末尾
    //剩余元素的排列是否要保证原有的相对顺序
    //是否有空间复杂度的要求
    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 0;
            int fast = 1;
            while (fast <= nums.length - 1) {
                if (nums[slow] != nums[fast]) {
                    //如果数组没有重复元素的话,nums[fast]和nums[slow+1]重叠 也就是出现自赋值 故而
                    // 加上 fast-slow >1 的判断
                    if (fast - slow > 1) {
                        nums[slow + 1] = nums[fast];
                    }
                    slow++;
                }
                fast++;
            }
            return slow + 1;
        }
    }
//main.java.leetcode submit region end(Prohibit modification and deletion)

}