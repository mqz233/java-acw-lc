package bishi.xiaomi;


import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class _0323_02 {

    class MyDeque {
        public ArrayDeque<Integer> q = new ArrayDeque<>();

        // add方法
        public void add(Integer num){
            // 维护一个递增队列 2 4 6 8
            // 3 加入弹出 4 6 8
            while (!q.isEmpty()&&num<q.getLast()){
                q.removeLast();
            }
            q.addLast(num);
        }

        // remove 方法
        public void remove(Integer num){
            // 和队头元素进行比较，和队头元素相等，则删除这个元素
            if (!q.isEmpty()&&Objects.equals(num, q.getFirst())){
                q.removeFirst();
            }
        }

        public int getMin(){
                return q.getFirst();
        }



    }
    static final int MAXN = 1000010;
    static int[] x = new int[MAXN];
    static int[] y = new int[MAXN];
    static int[] q1 = new int[MAXN];
    static int[] q2 = new int[MAXN];
    static int n, k, a, b;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();

        for (int i = 0; i < n; ++i)
            x[i] = scanner.nextInt();
        for (int i = 0; i < n; ++i)
            y[i] = scanner.nextInt();

        int front1 = 0, end1 = -1, front2 = 0, end2 = -1;
        for (int i = 0; i < n; ++i) {

            while (end1 >= front1 && i - k + 1 > q1[front1])
                front1++;
            while (end2 >= front2 && i - k + 1 > q2[front2])
                front2++;

            while (end1 >= front1 && x[i] <= x[q1[end1]])
                end1--;
            while (end2 >= front2 && y[i] <= y[q2[end2]])
                end2--;

            q1[++end1] = i;
            q2[++end2] = i;

            if (i + 1 >= k) {
                if (x[q1[front1]] >= a && y[q2[front2]] >= b)
                    ++cnt;
            }
        }

        System.out.println(cnt);
    }

    @Test
    public void test1(){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < n; ++i)
            x[i] = scanner.nextInt();

        for (int i = 0; i < n; ++i)
            y[i] = scanner.nextInt();

        MyDeque q1 = new MyDeque();
        MyDeque q2 = new MyDeque();

        int result = 0;

        for (int i=0; i<k;i++){
           q1.add(x[i]);
           q2.add(y[i]);
        }
        if (q1.getMin()>=a&&q2.getMin()>=b){
            result++;
        }
        for (int i=k;i<n;i++){
            q1.remove(x[i-k]);
            q2.remove(y[i-k]);
            q1.add(x[i]);
            q2.add(y[i]);
            if (q1.getMin()>=a&&q2.getMin()>=b){
                result++;
            }
        }
        System.out.println(result);

    }
}