package carl.sort;

import java.util.Arrays;

/**
 * @Author：Yan Zhaoyang
 * @Package：carl.sort
 * @Project：java-acw-lc
 * @name：HeapSort
 * @Date：2024/5/2 15:26
 * @Filename：HeapSort
 * @Desc：
 */
public class HeapSort {

    // 构建一个父节点大于孩子节点的完全二叉树，这样根节点最大，再把最后一个节点换到根节点，重新调整0,j-1
    // 无序序列 -> 构建堆 -> 末尾元素移到堆顶，调整 0-j
    // 从第一个非叶子节点开始调整 i = length/2 - 1
    // 调整：找到 自己和两个叶子节点中的最大值，交换到当前位置
    // 交换过后继续调整交换的节点，直到叶子节点/或未发生交换

    public void adjust(int[] arr, int index, int length){
        int max = arr[index];
        int next = index;
        int left = 2 * index + 1;
        if (left <length && max < arr[left]){
            max = arr[left];
            next = left;
        }
        int right = 2 * index + 2;
        if (right <length && max < arr[right]){
            max = arr[right];
            next = right;
        }
        if (next != index){
            swap(arr,index,next);
            adjust(arr, next, length);
        }
    }

    public void swap(int[] arr ,int a, int b){

        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;

    }

    public void sort(int[] arr){

        // build heap
        int length = arr.length;
        // 从第一个非叶子节点
        for (int j=length/2-1; j>=0; j--){
            adjust(arr, j, length);
        }
        // swap and adjust
        for (int i=length-1;i>0; i--){
            //swap
            swap(arr, i, 0);
            // adjust 0,i
            adjust(arr, 0, i);
        }

    }


    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }




}
