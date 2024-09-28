package _24sep;

public class LC528 {
    int[] arr;
    int sum;
    public LC528(int[] w) {
        arr = new int[w.length+1];
        for(int i=1;i<=w.length;i++){
            arr[i] = arr[i-1]+w[i-1];
        }
        sum = arr[w.length];
    }

    public int pickIndex() {
        double num = Math.random();
        int find = (int)(num*sum);
        int l = 1;
        int r = arr.length-1;
        // l以及l之后的保证大于等于find
        // r以及r左边的保证小于find
        // l==r等于的时候，让r再向左移一下 满足 r = l-1
        while(l<=r){
            int m = l + (r-l)/2;
            // find等于arr[m]的时候，也让r向左移动一下
            // 保证l最后等于r+1
            if(find <= arr[m]){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return l-1;
    }

    public static void main(String[] args) {
        int[] ints = {3, 14, 1, 7};
        LC528 lc528 = new LC528(ints);
        for (int i=0;i<10;i++){
            lc528.pickIndex();
        }
    }
}
