package leetcode.editor.sort;

import java.util.Random;
import java.util.function.Consumer;

public class SortTestHelper {
    //生成n个元素的随机数组 每个元素的随机范围为[rangL,rangR]
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    // 打印arr数组的所有内容
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value);
            System.out.print(' ');
        }
        System.out.println();

    }

    //生成n个元素的近乎有序数组 每个元素的随机范围为[rangL,rangR]
    public static int[] generateNearlyOrderedArray(int n, int swapTime) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < swapTime; i++) {
            int r1 = (int) (Math.random() * n);
            int r2 = (int) (Math.random() * n);
            swap(arr, r1, r2);
        }
        return arr;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void testSort(String sortName, Consumer<int[]> consumer, int[] arr) {
        long startTime = System.currentTimeMillis();
        consumer.accept(arr);
        long endTime = System.currentTimeMillis();
        if (isSorted(arr)) {
            System.out.println(sortName + ": " + (endTime - startTime) + "ms");
        }
    }

//    public static int[] copyArr(int[] arr) {
//        int[] copyArr = new int[arr.length];
//        System.arraycopy(arr, 0, copyArr, 0, arr.length);
//        return copyArr;
//    }

    public static void swap(Comparable[] arr, int l, int r) {
        Comparable temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
