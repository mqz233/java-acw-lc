package bishi.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _0424_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] split = scanner.nextLine().split(" ");
        ArrayList<Integer> score = new ArrayList<>(Collections.nCopies(n,0));
        ArrayList<Integer> conti = new ArrayList<>(Collections.nCopies(n,0));
        ArrayList<ArrayList<Integer>> fall = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0;i<n;i++){
            int con = 0;
            res.add(i);
            fall.add(new ArrayList<>());
            for (int j=0;j<m;j++){
                if (split[i].charAt(j) == '1'){
                    score.set(i,score.get(i)+1);
                    con++;
                    if (con>conti.get(i)){
                        conti.set(i,con);
                    }
                }else {
                    con = 0;
                    fall.get(i).add(j);
                }
            }
        }

        res.sort((a,b)->{
            // return 1 需要交换
            // return -1 不需要交换

            // 比较进球数量 进去数多的在前
            if (score.get(a)>score.get(b)) return -1;
            if (score.get(a)<score.get(b)) return 1;

            // 比较连续进球数，进球多的在前
            if (conti.get(a)>conti.get(b)) return -1;
            if (conti.get(a)<conti.get(b)) return 1;
            // 比较第一次射失，第二次射失。。。
            // 射失位置靠后的在前面
            int size = fall.get(a).size();
            for (int i=0; i<size; i++){
                if (fall.get(a).get(i)<fall.get(b).get(i)) return 1;
                if (fall.get(a).get(i)>fall.get(b).get(i)) return -1;
            }

            // 编号升序
            return a-b;

        });


        for (int i=0; i<res.size(); i++){
            System.out.print(res.get(i)+1);
            if (i != res.size()-1){
                System.out.print(' ');
            }
        }
    }
}
