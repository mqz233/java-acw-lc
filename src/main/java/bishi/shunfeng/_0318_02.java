package bishi.shunfeng;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _0318_02 {

    class Node{
        int l;
        int t;
    }

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int T = scanner.nextInt();
        Node[] arr = new Node[n];
        for (int i=0; i<n;i++){
            arr[i] = new Node();
            arr[i].l = scanner.nextInt();
            arr[i].t = scanner.nextInt();
        }
        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.t,o2.t);
            }
        });
//        Arrays.sort(arr,(x,y)-> Integer.compare(x.t,y.t));

//        Arrays.sort(arr, Comparator.comparingInt(x -> x.t));
        // 二分查找，二分的是钓鱼的数量 0-n，不断调整区间，找到最大钓鱼数量
        int l = 0;
        int r = n;
        int ans = 0;
        // 二分查找模板之全是闭区间
        while (l<=r){
            int mid =  (l+r)>>>1;
            if (check(arr,mid,T,n)){
                l=mid+1;
                ans = mid;
            }else {
                r = mid-1;
            }
        }

        System.out.println(ans);

    }

    // 检查是否能钓mid条鱼
    public boolean check(Node[] arr, int mid, int T,int n){
        int rT = T;
        int sum = 0;
        // 尝试钓鱼
        for (int i=0;i<n;i++){
            // 这条鱼钓不了，不满足limit
            if (arr[i].l<mid){
                continue;
            }
            // 剩余时间不足不能再钓了
            if (arr[i].t>rT){
                break;
            }
            sum++;
            rT = rT - arr[i].t;
        }

        return sum>=mid;
    }


}
