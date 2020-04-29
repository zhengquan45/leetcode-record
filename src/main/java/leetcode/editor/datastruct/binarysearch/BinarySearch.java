package leetcode.editor.datastruct.binarysearch;

public class BinarySearch<T extends Comparable> {

    public int search(T[] arr, T target) {
        //arr[l...r]查找target
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                r = mid - 1;
            } else if (arr[mid].compareTo(target) > 0) {
                l = mid + 1;
            }
        }
        return -1;
    }
}
