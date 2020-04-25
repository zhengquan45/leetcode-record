//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针


package leetcode.editor.cn;


public class SortColors {

    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            // nums[0...zero] == 0 nums[zero+1...i-1]==1 nums[two...n-1]
            int n = nums.length;
            int zero = -1;
            int two = n;
            int i = 0;
            while (i < two) {
                if(nums[i]==1) {
                    i++;
                } else if(nums[i]==0){
                    swap(nums,++zero,i++);
                }else if (nums[i]==2){
                    swap(nums,--two,i);
                }
            }
        }
        private void swap(int[] arr, int l, int r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)


    class Solution2 {
        public void sortColors(int[] nums) {
            int p0 = -1; // nums[0...p0] == 0
            int p2 = nums.length; //nums[p2...nums.length-1] == 2
            int i = 0;
            while (i < p2) {
                if (nums[i] == 0) {
                    p0++;
                    int temp = nums[p0];
                    nums[p0] = nums[i];
                    nums[i] = temp;
                    i++;
                }
                if (nums[i] == 1) {
                    i++;
                }
                if (nums[i] == 2) {
                    p2--;
                    int temp = nums[i];
                    nums[i] = nums[p2];
                    nums[p2] = temp;
                }
            }
        }
    }

    class Solution1 {
        public void sortColors(int[] nums) {
            int[] count = new int[3];
            for (int i = 0; i < nums.length; i++) {
                assert nums[i] >= 0 && nums[i] <= 2;
                count[nums[i]]++;
            }
            int index = 0;
            for (int k = 0; k < count.length; k++) {
                for (int j = 0; j < count[k]; j++) {
                    nums[index++] = k;
                }
            }
        }
    }
}