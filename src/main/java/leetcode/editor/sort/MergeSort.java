package leetcode.editor.sort;

public class MergeSort {

    //main.java.leetcode submit region begin(Prohibit modification and deletion)
    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    //递归调用 归并排序 对 arr[l...r]范围进行排序
    private static void mergeSort(int[] arr, int l, int r) {
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

    //把arr[l...mid]和[mid+1,r]进行归并
    private static void merge(int[] arr, int l, int mid, int r) {
        int tempLen = r - l + 1;
        int[] temp = new int[tempLen];
        for (int i = l; i <= r; i++) {   // 把[l..r] 游标i 复制到temp[0...r-l] 游标i-l l是偏移量
            temp[i - l] = arr[i];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {// 说明[l...mid]都进入arr 把temp右边剩余的数即temp[j-l]继续循环j++ 到j>r
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {// 说明[mid+1...r]都进入arr 把temp左边剩余的数即temp[i-l]继续循环i++ 到i>mid
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l] < temp[j - l]) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }


}
