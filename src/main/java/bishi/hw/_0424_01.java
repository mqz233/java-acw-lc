package bishi.hw;

import java.util.Arrays;
import java.util.Scanner;

public class _0424_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        res.append("S");
        int[] num = new int[1100];
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        for (int i=0;i<s1.length;i++){
            num[i] = Integer.parseInt(s1[i]);
        }
        int find = scanner.nextInt();
        Arrays.sort(num);
        int l = 0;
        int r = s1.length-1;
        // 记录树深度
        int d = 0;
        while(l<=r){
            d++;
            int mid = l+(r-l)/2;
            if (num[mid] == find){
                res.append("Y");
                break;
            }
            if (find>num[mid]){
                if((1<<d) > s1.length){
                    break;
                }
                l = mid+1;
                res.append("R");
                continue;
            }
            if(find<num[mid]){
                if((1<<d) > s1.length){
                    break;
                }
                r = mid-1;
                res.append("L");
                continue;
            }

        }

        if(res.charAt(res.length()-1)!='Y'){
            res.append("N");
        }

        System.out.println(res);


    }

}
