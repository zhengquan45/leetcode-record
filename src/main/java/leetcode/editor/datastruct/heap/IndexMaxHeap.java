package leetcode.editor.datastruct.heap;

import static leetcode.editor.sort.SortTestHelper.swap;

// 为了解决MaxHeap在Heapify过程中打乱索引,导致无法通过索引访问数据
public class IndexMaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int[] indexes;
    protected int[] reverse;
    protected int count;
    protected int capacity;

    public IndexMaxHeap(int capacity) {
        this.indexes = new int[capacity + 1];
        this.reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            this.reverse[i] = 0;
        }
        this.data = (Item[]) new Comparable[capacity + 1];// 从索引1开始 0不使用
        this.capacity = capacity;
    }

    public IndexMaxHeap(Item[] arr) {
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

    void insert(int index, Item item) {
        if (count + 1 > capacity) {
            throw new IllegalStateException("capacity is not enough ! need resize");
        }
        if (index + 1 < 1 || index + 1 > capacity) {
            throw new IndexOutOfBoundsException();
        }
        index++;//纠正用户索引0开始到目前数据结构从索引1开始
        indexes[count + 1] = index;
        reverse[index] = count + 1;
        count++;
        shiftUp(count);
    }

    Item extractMax() {
        if (count <= 0) {
            throw new IllegalStateException("heap has no element");
        }
        Item result = data[indexes[1]];
        swap(indexes, 1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return result;
    }

    int extractMaxIndex() {
        if (count <= 0) {
            throw new IllegalStateException("heap has no element");
        }
        int result = indexes[1] - 1;
        swap(indexes, 1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return result;
    }

    Item get(int index) {
        return data[index];
    }

    void change(int index, Item item) {
        index++;//纠正 内部索引1 外部索引0
        data[index] = item;
        //找到indexes[j] = index.j表示data[index]在堆中的位置
        //之后shiftUp(j),再shiftDown(j)
        int j = reverse[index];
        shiftUp(j);
        shiftDown(j);
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            //大于则超出范围没有该左节点 所以跟没有右节点
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                //说明有右节点 且大于左节点
                j += 1; //右节点大
            }
            //左节点大
            if (data[indexes[k]].compareTo(data[indexes[j]]) < 0) {
                swap(indexes, k, j);
                reverse[indexes[k]] = k;
                reverse[indexes[j]] = j;
            }
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) < 0) {
            swap(indexes, k / 2, k);
            reverse[indexes[k / 2]] = k / 2;
            reverse[indexes[k]] = k;
            k /= 2;
        }
    }
}
