package leetcode.editor.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static leetcode.editor.sort.SortTestHelper.printArray;
import static leetcode.editor.sort.SortTestHelper.testSort;

class SortTest {

    @Test
    void selectionSort() {
        // 测试排序算法辅助函数
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        testSort("SelectionSort", SelectionSort::sort, arr);
        printArray(arr);
    }

    @Test
    void insertionSort() {
        // 测试排序算法辅助函数
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        testSort("InsertionSort", InsertionSort::sort, arr);
        printArray(arr);
    }

    @Test
    void bubbleSort() {
        // 测试排序算法辅助函数
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        testSort("BubbleSort", BubbleSort::sort, arr);
        printArray(arr);
    }

    @Test
    void ShellSort() {
        // 测试排序算法辅助函数
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        testSort("ShellSort", ShellSort::sort, arr);
        printArray(arr);
    }

    @Test
    void mergeSort() {
        int N = 1000000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        int[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);

        testSort("InsertionSort", InsertionSort::sort, arr1);
        testSort("MergeSort", MergeSort::sort, arr2);

        System.out.println();


        // 测试2 测试近乎有序的数组
        // 对于近乎有序的数组, 数组越有序, InsertionSort的时间性能越趋近于O(n)
        // 所以可以尝试, 当swapTimes比较大时, MergeSort更快
        // 但是当swapTimes小到一定程度, InsertionSort变得比MergeSort快
        int swapTimes = 10;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        testSort("InsertionSort", InsertionSort::sort, arr1);
        testSort("MergeSort", MergeSort::sort, arr2);
    }

    @Test
    void MergeSortBU() {
        // 测试排序算法辅助函数
        int N = 20000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        testSort("MergeSortBU", MergeSortBU::sort, arr);
        printArray(arr);
    }

    @Test
    void QuickSort() {
        // 测试排序算法辅助函数
        int N = 50000;
        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        int[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        testSort("QuickSort", QuickSort::sort, arr1);
        printArray(arr1);

        int swapTimes = 10;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);
        int[] arr2 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        testSort("QuickSort", QuickSort::sort, arr2);
        printArray(arr2);


        System.out.println("Test for small range random array, size = " + N + " , swap time = " + swapTimes);
        int[] arr3 = SortTestHelper.generateRandomArray(N, 0, 10);
        int[] arr4 = Arrays.copyOf(arr3,arr3.length);
        int[] arr5 = Arrays.copyOf(arr3,arr3.length);
        testSort("QuickSort", QuickSort::sort, arr3);
        testSort("QuickSort2Way", QuickSort2Way::sort, arr4);
        testSort("QuickSort3Way", QuickSort3Way::sort, arr5);
        printArray(arr3);
    }}