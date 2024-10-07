package _24sep;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LC84 {
    public int largestRectangleArea(int[] heights) {
        // 用单调栈，分别找到左边最近的比自己小的，找不到就是-1，和右边最近的比自己小的，找不到就是n
        // r[i]-l[i]-1 就是heights[i]能计算面积的最大宽
        int n = heights.length;
        int max = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] l = new int[n];
        // 填充为-1
        Arrays.fill(l,-1);
        for(int i=0;i<n;i++){
            // 当前小于栈顶，移除栈顶
            while(!q.isEmpty()&& heights[i]<=heights[q.getLast()]){
                q.removeLast();
            }
            // 入栈，栈不为空则答案为栈顶，否则为默认值-1
            if(!q.isEmpty()){
                l[i] = q.getLast();
            }
            q.addLast(i);
        }
        q.clear();
        int[] r = new int[n];
        Arrays.fill(r,n);
        for(int i=n-1;i>=0;i--){
            while(!q.isEmpty()&&heights[i]<=heights[q.getLast()]){
                q.removeLast();
            }
            if(!q.isEmpty()){
                r[i] = q.getLast();
            }
            q.addLast(i);
        }
        for(int i=0;i<n;i++){
            int size = (r[i]-l[i]-1)*heights[i];
            if(size > max){
                max = size;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        LC84 lc84 = new LC84();
        // 2
        // 1
        lc84.largestRectangleArea(new int[]{1,1});
    }
}
