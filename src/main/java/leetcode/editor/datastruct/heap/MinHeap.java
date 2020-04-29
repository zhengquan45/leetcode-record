package leetcode.editor.datastruct.heap;

import static leetcode.editor.sort.SortTestHelper.swap;

//索引从1开始
public class MinHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity;

    public MinHeap(int capacity) {
        this.data = (Item[]) new Comparable[capacity + 1];// 从索引1开始 0不使用
        this.capacity = capacity;
    }

    public MinHeap(Item[] arr) {
        int n = arr.length;
        this.data = (Item[]) new Comparable[n + 1];// 从索引1开始 0不使用
        this.capacity = n;
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;
        // Heapify
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    void insert(Item item) {
        if (count + 1 > capacity) {
            throw new IllegalStateException("capacity is not enough ! need resize");
        }
        data[++count] = item;
        shiftUp(count);
    }

    Item extractMin() {
        if (count <= 0) {
            throw new IllegalStateException("heap has no element");
        }
        Item result = data[1];
        swap(data, 1, count--);
        shiftDown(1);
        return result;
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            //大于则超出范围没有该左节点 所以跟没有右节点
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) < 0) {
                //说明有右节点 且大于左节点
                j += 1; //右节点大
            }
            //左节点大
            if (data[k].compareTo(data[j]) > 0) {
                swap(data, k, j);
            }
            k = j;
        }
    }

    private void shiftUp(int k) {
        //1 k位置元素不是顶部元素 2 父元素比自己大
        while (k > 1 && data[k / 2].compareTo(data[k]) > 0) {
            swap(data, k / 2, k);
            k /= 2;
        }
    }
}
