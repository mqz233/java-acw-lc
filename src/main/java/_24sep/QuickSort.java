package _24sep;

/**
 * 快速排序: Java
 *
 * @author skywang
 * @date 2014/03/11
 */

public class QuickSort {

    /*
     * 快速排序
     *
     * 参数说明:
     *     a -- 待排序的数组
     *     l -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     *     r -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static void quickSort(int[] a, int l, int r) {

        if (l < r) {
            int i,j,x;

            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while(i < j && a[j] > x)
                    j--; // 从右向左找第一个小于x的数
                if(i < j)
                    a[i++] = a[j];
                while(i < j && a[i] < x)
                    i++; // 从左向右找第一个大于x的数
                if(i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, l, i-1); /* 递归调用 */
            quickSort(a, i+1, r); /* 递归调用 */
        }
    }

    public static void myQuickSort(int[] a,int left,int right){
        if(left<right){
            int x = a[left];
            int l = left;
            int r =right;
            while(l<r){
                while(l<r && a[r]>=x) r--;
                while(l<r && a[l]<=x) l++;
                if(l<r){
                    int tmp = a[l];
                    a[l] = a[r];
                    a[r] = tmp;
                }
            }
            int tmp = a[r];
            a[r] = a[left];
            a[left] = tmp;
            myQuickSort(a,left,r-1);
            myQuickSort(a,r+1,right);
        }

    }

    public static void adjust(int[] a,int i,int right){
        int max = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<=right && a[l]>a[max]) max = l;
        if(r<=right &&a[r]>a[max]) max = r;
        if(max!=i){
            swap(a,i,max);
            adjust(a,max,right);
        }
    }

    public static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void myHeapSort(int[] a,int left,int right){
        int index = (a.length/2)-1;
        for(int i=index;i>=0;i--){
            adjust(a,i,right);
        }
        for(int i=right;i>=left;i--){
            swap(a,i,left);
            adjust(a,0,i-1);
        }
    }

    public static void main(String[] args) {
        int i;
        int a[] = {50,60,10,40,30,20};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        myHeapSort(a, 0, a.length-1);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
