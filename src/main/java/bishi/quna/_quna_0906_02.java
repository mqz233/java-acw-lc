package bishi.quna;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//
//public class _quna_0906_02 {
//    public static void main(String[] args) {
//
//        int [] nums1 = new int[]{1,2,3,4,5};
//        int [] nums2 = new int[]{4,2,3,5,10};
//        int count = 20;
//
//        for(int i=0;i<nums1.length;i++){
//            Arrays.sort(nums1,0,i+1);
//            Arrays.sort(nums2,0,i+1);
//            int sum = 0;
//            for(int j=0;j<=i;j++){
//                sum += (nums1[j]*nums2[j]);
//            }
//            if(sum>=count){
//                System.out.println(i+1);
//                break;
//            }
//
//        }
//
//    }
//}

import java.util.PriorityQueue;

public class _quna_0906_02 {
//    public  static int findMinIndexForSum(int[] nums1, int[] nums2, int k) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
//        int n = nums1.length;
//
//        // 初始化前缀和数组
//        int[] prefixSum1 = new int[n + 1];
//        int[] prefixSum2 = new int[n + 1];
//
//        // 计算前缀和
//        for (int i = 0; i < n; i++) {
//            prefixSum1[i + 1] = prefixSum1[i] + nums1[i];
//            prefixSum2[i + 1] = prefixSum2[i] + nums2[i];
//        }
//
//        // 记录当前最大乘积和
//        int maxSum = 0;
//        int result = n;
//
//        for (int i = 0; i < n; i++) {
//            // 加入当前元素的乘积
//            pq.offer(new int[]{nums1[i] * nums2[i], i});
//
//            // 从队列中取出最大乘积
//            while (!pq.isEmpty() && maxSum + pq.peek()[0] >= k) {
//                int[] product = pq.poll();
//                int currentProduct = product[0];
//                int currentIndex = product[1];
//
//                // 更新最大乘积和
//                maxSum += currentProduct;
//
//                // 更新最小下标
//                result = Math.min(result, currentIndex + 1);
//
//                // 如果已经找到合适的下标，则直接返回
//                if (maxSum >= k) {
//                    break;
//                }
//            }
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
////        Solution solution = new Solution();
//        int[] nums1 = {1, 2, 3,4,5};
//        int[] nums2 = {4, 2, 3,5,10};
//        int k = 20;
//        System.out.println(_quna_0906_02.findMinIndexForSum(nums1, nums2, k)); // 应输出 "3" 或者 "2" 根据实际情况
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        long m = Integer.parseInt(inputs[1]);
        int[] a = new int[n];
        String[] as = reader.readLine().split(" ");
        for (int i = 0; i < n; ++ i) a[i] = Integer.parseInt(as[i]);
        int[] b = new int[n];
        String[] bs = reader.readLine().split(" ");
        for (int i = 0; i < n; ++ i) b[i] = Integer.parseInt(bs[i]);

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(mid, a, b, m)) {
                r = mid - 1;
            }
            else l = mid + 1;
        }

        System.out.println(l >= n ? -1 : (l + 1));
    }

    private static boolean check(int k, int[] a, int[] b, long limit) {
        int[] a_copy = Arrays.copyOfRange(a, 0, k + 1);
        Arrays.sort(a_copy);
        int[] b_copy = Arrays.copyOfRange(b, 0, k + 1);
        Arrays.sort(b_copy);

        long t = 0L;
        for (int i = k; i >= 0; -- i) {
            t += (long) a_copy[i] * b_copy[i];
            if (t >= limit) return true;
        }
        return false;
    }
}
