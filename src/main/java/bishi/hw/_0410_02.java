package bishi.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _0410_02 {

    public static int find(int x, int[] father){
        if (x == father[x]) return x;
        return find(father[x],father);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] father = new int[n];
        for (int i=0;i<n;i++){
            father[i] = i;
        }
        int[] res = new int[n];
        scanner.nextLine();
        for (int i=0; i<n; i++){
            String[] split = scanner.nextLine().split(" ");
            for (int j=i+1; j<n; j++){
                if (Integer.parseInt(split[j])!=0){
                    father[j] = i;
                    // 找到根
                    // 记录值
                    res[find(j,father)]+=Integer.parseInt(split[j]);
                    res[j] = -1;
                }
            }
        }
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i=0;i<n;i++){
            if (find(i,father) == i){
                resList.add(res[i]);
            }
        }
        resList.sort((a,b)->b-a);
        StringBuilder sb = new StringBuilder();

        for (int num:resList){
            sb.append(num);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
