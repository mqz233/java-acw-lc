package _24aug;

import java.util.*;

public class MyHeapSort {

    void heapSort(int[] arr) {
        // 从第一个非叶子节点开始调整
        int index = (arr.length >> 1) - 1;
        // 构建大顶堆，顶部是最大的
        for (int i = index; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        // 开始排序
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjust(arr, 0, i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    // 参数length代表最多能调整多少
    void adjust(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < length) {
            if (arr[left] > arr[max]) {
                max = left;
            }
        }
        if (right < length) {
            if (arr[right] > arr[max]) {
                max = right;
            }
        }
        swap(arr, i, max);
        if (left < length) {
            adjust(arr, left, length);
        }
        if (right < length) {
            adjust(arr, right, length);
        }


    }

    void heapSort2(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        int size = q.size();
        for (int i = 0; i < size; i++) {
            // a-b 是升序，小顶堆，每次删除的是最小的元素
            // b-a 降序 大顶堆 每次删除的是最大的元素
            System.out.println(q.poll());
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{43, 66, 43, 112, 21, 9, 222};
        new MyHeapSort().heapSort2(arr);
    }
}
