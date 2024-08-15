package aug;
import java.util.*;
/*
* 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。



示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]


提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
* */
public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // [1,3,1,2,0,5]
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int sum = 0;
        for(int i=0; i<k; i++){
          while(!q.isEmpty()&&nums[i]>nums[q.getLast()]){
              q.removeLast();
          }
          q.addLast(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[q.getFirst()]);

        for(int i=k;i<nums.length;i++){
            if(!q.isEmpty()){
                int index = q.getFirst();
                if(i-index >= k) {
                  q.removeFirst();
                }
            }

            while(!q.isEmpty()&&nums[i]>nums[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
            res.add(nums[q.getFirst()]);

        }
        return res.stream().mapToInt(j->j).toArray();

    }

    public static void main(String[] args) {
        LC239 lc238 = new LC239();
        lc238.maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
    }
}
