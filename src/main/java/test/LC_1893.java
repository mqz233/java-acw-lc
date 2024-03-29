package test;

public class LC_1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {


        // left-right 之间是否被覆盖->数组值是否大于0
        // 数组值计算，遍历每个range，遇到的就+1，range size为l,共有n个range
        // O(n*l)
        // 像这种数组中每个数字都进行相同操作的（本题是一个range内的都加1），就可以用差分数组
        // a[i] 为原数组 0 0 0 0 0
        // 0-3都加1 -> 1 1 1 1 0
        // 差分数组b[j] 0 0 0 0 0 -> 1 0 0 0 -1
        // 规律a[c]-a[d] 之间都加1
        // b[c]++ b[d+1]--
        // 本题对于每个range，只需要计算差分数组的两个变化值，时间复杂度 2*n
        // 再利用前缀和还原数组 时间复杂度为差分数组长度，一个定值

        // range 1-50
        int[] diff = new int[52];
        int[] arr = new int[52];
        for (int[] range:ranges){
            int size = range.length;
            diff[range[0]] += 1;
            diff[range[range.length-1]+1] -= 1;
        }

        arr[0] = diff[0];
        for (int i=1; i<diff.length;i++){
            arr[i] = arr[i-1]+diff[i];
        }
        for (int i=left;i<=right;i++){
            if (arr[i]==0){
                return  false;
            }
        }
        return true;

    }
}
