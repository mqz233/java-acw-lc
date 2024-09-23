package test;

import java.util.*;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public int maximizeDonations (int[] donations) {
        if(donations.length==1){
            return  donations[0];
        }

        if(donations.length==2){
            return  Math.max(donations[0],donations[1]);
        }
        int n = donations.length;
        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n-1];
        dp1[0] = donations[0];
        dp1[1] = Math.max(donations[0],donations[1]);
        dp2[0] = donations[1];
        dp2[1] = Math.max(donations[1],donations[2]);
        for(int i=2;i<n-1;i++){
            dp1[i] = Math.max(dp1[i-2]+donations[i],dp1[i-1]);
        }
        for(int i=2;i<n-1;i++){
            dp2[i] = Math.max(dp2[i-2]+donations[i+1],dp2[i-1]);
        }


        return Math.max(dp1[n-2],dp2[n-2]);
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.maximizeDonations(new int[]{10,3,2,5,7,8,11});
    }
}