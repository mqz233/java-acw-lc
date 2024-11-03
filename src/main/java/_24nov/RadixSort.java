package _24nov;


import java.util.Arrays;

public class RadixSort {
    // 0-9 十个桶
    //  (1)统计最大数的位数
    //  (2)确定进制 -- 10进制
    //  (3)分别取出来个位，十位，百位的数字
    //  (4)做词频统计 -- cnts
    //  (5)计算成累加数组 cnts[i] = cnts[i]+cnts[i-1]
    //  (6)从右向左遍历原数组，取到对应的每位的数字，得到在词频中的位置，然后在helper数组中保存到最新的位置
    //  (7)放回原数组

    final static int BASE = 10;

    final static int MAXN = 100001;

    static int[] arr = new int[MAXN];

    static int[] helper = new int[MAXN];

    static int[] cnts = new int[BASE];

    public static void radixSort(int n, int bits) {
        // 一共进行几次基数排序
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(cnts, 0);
            // 词频统计
            for (int i = 0; i < n; i++) {
                cnts[(arr[i] / offset) % BASE]++;
            }
            // 累加，确定这次排序后的新位置
            for(int i=1;i<n;i++){
                cnts[i] += cnts[i-1];
            }
            // 从右往左遍历数组，放到新位置
            for(int i=n-1;i>=0;i--){
                helper[--cnts[(arr[i]/offset)%BASE]] = arr[i];
            }
            for(int i=0;i<n;i++){
                arr[i] = helper[i];
            }
        }

    }

    public static void main(String[] args) {
        int max = 19;
        for (int i=0;i<10;i++){
            arr[i] = max--;
        }
        radixSort(10,2);
    }
}
