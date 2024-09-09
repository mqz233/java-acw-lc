package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n+1];
        String s = sc.nextLine();
        for(int i=0;i<n;i++){
            nums[i+1] = nums[i]+ (s.charAt(i) == 'A'?1:-1);
        }
        int max = 0;
        for(int i=0;i<=n;i++){
            for(int j=n;j>=i;j--){
                if(nums[j]-nums[i] == 0){
                    if(j-i > max){
                        max = j-i;
                    }
                }
            }
        }

        System.out.println(max);

    }

//    public static void main(String[] args) {
//        // 3
//        //3 3
//        //2 2 8
//        //2 2
//        //-4 -7
//        //7 2
//        //8 14 -9 6 0 -1 3
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for(int i=0;i<T;i++){
//            int n = sc.nextInt();
//            int k = sc.nextInt();
//            long[] nums = new long[n];
//            long sum = 0;
//            for(int j=0;j<nums.length;j++){
//                nums[j] = sc.nextLong();
//                sum+=nums[j];
//            }
//            long[] prefix = new long[n+1];
//            for(int j=1;j<=n;j++){
//                prefix[j] = nums[j-1]+prefix[j-1];
//            }
//            long max = 0;
//            for(int j=0;j<=n;j++){
//                for(int q=n;q>=j;q--){
//                    if (prefix[q] - prefix[j] > max) {
//                        max = prefix[q] - prefix[j];
//                    }
//                }
//            }
//
//            for(int j=0;j<k;j++){
//                sum+= max;
//                max = max*2;
//            }
//            if(sum < 0){
//                sum = sum % (1000000007L);
//                sum += 1000000007L;
//            }else{
//                sum = sum % (1000000007L);
//            }
//
//
//            System.out.println(sum);
//
//        }
//    }


}
