package bishi.pdd;

import java.util.Scanner;

//1
//        9 6
//        1
//        4
//        7
//        1
//        3
//        6
//        8
//        10
//        9
public class _0509_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        for (int i=0;i<num;i++){
            String[] split = in.nextLine().split(" ");
            int n= Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int[] nums = new int[n];
            for (int k=0;k<n;k++){
                nums[k] = in.nextInt();
            }
            int sum=0;
            for (int j=0; j<m; j++){
                sum+=nums[j];
            }
            float tmpAvg = (float)sum/m;
            float maxAvg = tmpAvg;

            int p = m;
            int left = 0;
            int count = m;
            while (p<nums.length){
                if ((float)nums[p]>tmpAvg){
                    if ((float)nums[left]<tmpAvg){
                        sum-=nums[left];
                        left++;
                        sum+=nums[p];
                        p++;
                        tmpAvg = (float)sum/count;
                        if (tmpAvg>maxAvg){
                            maxAvg = tmpAvg;
                        }
                    }else {
                        sum+=nums[p];
                        p++;
                        count++;
                        tmpAvg = (float)sum/count;
                        if (tmpAvg>maxAvg){
                            maxAvg = tmpAvg;
                        }
                    }
                }else if (count>m&&nums[left]<tmpAvg){
                    while (count>m&&nums[left]<tmpAvg){
                        sum-=nums[left];
                        left++;
                        tmpAvg = (float)sum/count;
                        count--;
                    }
                    if (tmpAvg>maxAvg){
                        maxAvg = tmpAvg;
                    }
                }
                else {
                    if (tmpAvg>maxAvg){
                        maxAvg = tmpAvg;
                    }
                    sum-=nums[left];
                    left++;
                    sum+=nums[p];
                    p++;
                    tmpAvg = (float)sum/count;



                }
                if (tmpAvg>maxAvg){
                    maxAvg = tmpAvg;
                }
            }

            // 浮点数保留小数
            System.out.println(String.format("%.3f", maxAvg) );

//            Float aFloat = maxAvg;
//            String[] split2 = aFloat.toString().split("\\.");
//            if (Integer.parseInt(String.valueOf(split2[1].charAt(3)))>=5){
//                System.out.println(split2[0]+"."+split2[1].substring(0,2)+(Integer.parseInt(String.valueOf(split2[1].charAt(2)))+1));
//            }else {
//                System.out.println(split2[0]+"."+split2[1].substring(0,3));
//            }

        }
    }

}
