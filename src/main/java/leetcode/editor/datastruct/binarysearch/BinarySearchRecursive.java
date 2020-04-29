package leetcode.editor.datastruct.binarysearch;

public class BinarySearchRecursive<T extends Comparable> {

    public int search(T[] arr, T target) {
        //arr[l...r]查找target
        int l = 0, r = arr.length - 1;
        return binarySearch(arr, l, r,target);
    }

    private int binarySearch(T[] arr, int l, int r, T target) {
        int mid = l + (r - l) / 2;
        if(arr[mid]== target)return mid;
        else if(arr[mid].compareTo(target)>0)return binarySearch(arr,l,mid-1,target);
        else return binarySearch(arr,mid+1,r,target);
    }

    public static void main(String[] args) {
        Integer[]arr = {1,3,4,6,9,10,15};
        BinarySearchRecursive search = new BinarySearchRecursive();
        int index = search.search(arr,4);
        System.out.println(index);
    }
}
