package bishi.yongyou;
import java.util.*;

/**
 * @description:
 */
public class _0814_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        int[] res = new int[length];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        //输入
        //6
        //1 3 2 4 3 5
        //输出
        //1 3 1 5 1 6
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            // 非单调递减，开始弹出
            while(!q.isEmpty()&&nums[i]>nums[q.getLast()]){
                // 弹出时计算长度
                int tmp = q.removeLast();
                res[tmp] = i-res[tmp]-1;
            }
            // 弹到为空了，那么左边不存在比他大的
            if(q.isEmpty()){
                res[i] = -1;
                q.addLast(i);
            }else{
                // 左边比它大的是栈顶元素
                res[i] = q.getLast();
                q.addLast(i);
            }

        }
        // 栈里剩下的元素一块计算
        while(!q.isEmpty()){
            int tmp = q.removeLast();
            res[tmp] = tmp-res[tmp];
        }

        for (int i=0;i<res.length;i++){
            System.out.println(res[i]+" ");
        }

    }
}
