package acwing;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {

        Set<Integer> hSet = new HashSet<>();
        hSet.add(n);
        int next = cal(n);
        // 不是or条件而是and条件
        while(!hSet.contains(next) && next != 1){
            hSet.add(next);
            next = cal(next);
        }

        return next == 1;
    }

    public int cal(int n) {

        int r = 0;
        // 等于10也可以继续取余
        while (n >= 10) {
            r += (n % 10) * (n % 10);
            n = n / 10;
        }
        r += (n % 10) * (n % 10);

        return r;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }
}
