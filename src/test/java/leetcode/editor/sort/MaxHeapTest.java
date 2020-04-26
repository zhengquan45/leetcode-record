package leetcode.editor.sort;

import leetcode.editor.datastruct.heap.MaxHeap;
import leetcode.editor.datastruct.heap.PrintableMaxHeap;
import org.junit.jupiter.api.Test;

public class MaxHeapTest {

    @Test
    public void function() {
        PrintableMaxHeap maxHeap = new PrintableMaxHeap(100);
        int N = 10; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++)
            maxHeap.insert(new Integer((int) (Math.random() * M)));
        maxHeap.treePrint();

        for (int j = 0; j < N; j++) {
            System.out.print(maxHeap.extractMax() + " ");
        }
    }

    @Test
    public void heapSort() {
        MaxHeap maxHeap = new MaxHeap(5);
        int N = 10;
        int[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        for (int i : arr1) {
            maxHeap.insert(i);
        }
        for (int i = 0; i < N; i++) {
            Integer num = (Integer) maxHeap.extractMax();
            System.out.print(num + " ");
        }

    }
}
