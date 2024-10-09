package _24oct;
import java.util.*;


public class LC560 {
    public int subarraySum1(int[] nums, int k) {
        // 有负数，不能用滑动窗口
        // 前缀和，并且用Map记录，key为和，value为个数
        int n = nums.length;
        int[] arr = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<n;i++){
            if(i == 0){
                arr[0] = nums[0];
            }else{
                arr[i] = arr[i-1]+nums[i];
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.containsKey(arr[i]-k)){
                res += map.get(arr[i]-k);
            }

        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        // 有负数，不能用滑动窗口
        // 前缀和，并且用Map记录，key为和，value为个数
        int n = nums.length;
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化
        // 假设nums为[1],k=1，那么要有一个(0,1)才能计算到这种情况
        map.put(0,1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[0] = nums[0];
            } else {
                arr[i] = arr[i - 1] + nums[i];
            }
            // 要先计算当前总和减去k有几种，再去put,防止k为0的情况，多算一种
            if (map.containsKey(arr[i] - k)) {
                res += map.get(arr[i] - k);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);


        }
        return res;
    }

    public static void main(String[] args) {
        LC560 lc560 = new LC560();
        lc560.subarraySum(new int[]{1,1,1},2);
    }
}
