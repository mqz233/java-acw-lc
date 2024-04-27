package carl.sort;

public class QuickSort {
    static void  fnc(int[] arr,int left, int right){

        if (left > right) return;
        int tmp = arr[left];
        int l = left;
        int r = right;
        while(l<r){
            // 为什么要先从右边找
            while (arr[r]>=tmp&&l<r){
                r--;
            }
            while (arr[l]<=tmp&&l<r){
                l++;
            }

            if (l<r){
                int tmp2 = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp2;
            }
        }
        arr[left] = arr[l];
        arr[l] = tmp;

        fnc(arr,left,r-1);
        fnc(arr,r+1,right);
    }

    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{10,7,2,4,7,62,3,4,2,1,8,9,19};
        fnc(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
