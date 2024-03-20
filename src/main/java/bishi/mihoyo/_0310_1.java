package bishi.mihoyo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class _0310_1 {
    public static void main(String[] args) {

    }

    @Test
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        // 获取格子数量
        int num = scanner.nextInt();
        // 初始化每个物品位置
        int[] loc = new int[num];
        // 记录每个物品移动方向
        int[] objs = new int[num];
        for (int i = 0; i < num; i++) {
            objs[i] = scanner.nextInt();
            loc[i] = i;
        }
        for (int i=0; i<num;i++){
            int tmp = 0;
            for (int j=0; j<num;j++){
                if (objs[j]==0){
                    loc[j]--;
                }
                else {
                    loc[j]++;
                }
                if (loc[j]>=0&&loc[j]<num){
                    tmp++;
                }
            }
            System.out.print(num - tmp);
            System.out.print(" ");
        }



    }
}
