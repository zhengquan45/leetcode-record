package leetcode.editor.datastruct.heap;

import static leetcode.editor.sort.SortTestHelper.swap;

public class MaxHeapBeginZero<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity;

    public MaxHeapBeginZero(int capacity) {
        this.data = (Item[]) new Comparable[capacity];
        this.capacity = capacity;
    }

    public MaxHeapBeginZero(Item[] arr) {
        int n = arr.length;
        this.data = arr;
        this.capacity = n;
        this.count = n;
        // Heapify
        int notLeafLast = (count - 1) / 2;
        for (int i = notLeafLast; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Item item) {
        if (count + 1 > capacity) {
            throw new IllegalStateException("capacity is not enough ! need resize");
        }
        data[count] = item;
        shiftUp(count);
        count++;
    }

    public Item extractMax() {
        if (count <= 0) {
            throw new IllegalStateException("heap has no element");
        }
        Item result = data[0];
        swap(data, 0, --count);
        shiftDown(0);
        return result;
    }

    private void shiftDown(int k) {
        while (2 * k + 1 < count) {
            //大于则超出范围没有该左节点 所以跟没有右节点
            int j = 2 * k + 1;
            if (j + 1 < count && data[j + 1].compareTo(data[j]) > 0) {
                //说明有右节点 且大于左节点
                j += 1; //右节点大
            }
            //左节点大
            if (data[k].compareTo(data[j]) < 0) {
                swap(data, k, j);
            }
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 0 && data[(k - 1) / 2].compareTo(data[k]) < 0) {
            swap(data, (k - 1) / 2, k);
            k = (k - 1) / 2;
        }
    }

    public static void main(String[] args) {
        MaxHeapBeginZero<Integer> heap = new MaxHeapBeginZero<>(10);
        int N = 10; // 堆中元素个数
        int M = 10; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++)
            heap.insert(new Integer((int) (Math.random() * M)));
        for (int j = 0; j < N; j++) {
            System.out.print(heap.extractMax() + " ");
        }
    }
}
