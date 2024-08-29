package _24aug;

import java.util.*;

public class LC368 {
    public List<Integer> lexicalOrder_g(int n) {
        // 123
        // 1 10 11 12 ..... 19 100 101 102 ... 109 110
        // 计算第一位的数字
        int num = n;
        // 计算一共有几位数字
        int count = 1;
        while (num >= 10) {
            num = num / 10;
            count++;
        }
        // 最开始从1开始
        int index = 1;
        List<Integer> res = new ArrayList<>();
        while (index < num) {
            for (int i = 1; i <= count; i++) {
                // 根据位数 开始向res添加
                int mul = (int) Math.pow(10, i - 1);
                // 1 10 100
                int start = index * mul;
                for (int j = 0; j < mul; j++) {
                    // 10 11 12 ... 19
                    res.add(start + j);
                }
            }
            index++;
        }
        // index为Num 不能全部添加
        // 28 index为2
        for (int i = 1; i <= count; i++) {
            int mul = (int) Math.pow(10, i - 1);
            int start = index * mul;
            // 到达最大位数
            if (i == count) {
                for (int j = 0; j < mul; j++) {
                    // 及时break掉
                    if (start + j <= n) {
                        res.add(start + j);
                    } else {
                        break;
                    }
                }
            } else {
                for (int j = 0; j < mul; j++) {
                    res.add(start + j);
                }
            }
        }
        index++;

        // count >=2 补全缺的几位数
        if(count>=2){
            while(index<=9){
                res.add(index);
                index++;
            }
        }

        return res;
    }

    // 234 1 10 100 101 .. 109 11 110 111 .. 119
    public List<Integer> lexicalOrder(int n){
        for(int i=1;i<=9;i++){
            fnc(i,n);
        }
        return res;
    }

    List<Integer> res = new ArrayList<>();
    public void fnc(int cur,int n){
        if(cur > n) return;
        res.add(cur);
        for(int i=0;i<=9;i++){
            fnc(cur*10+i,n);
        }

    }

    public static void main(String[] args) {
        LC368 lc368 = new LC368();
        lc368.lexicalOrder(38);
    }
}
