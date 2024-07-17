package july;
import java.util.*;

/**
 * @Desc：给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 */
public class LC496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        for(int i=1; i<nums2.length; i++){
            while(!q.isEmpty()&&nums2[i]>nums2[q.getLast()]){
                int tmp = q.removeLast();
                map.put(nums2[tmp],nums2[i]);
            }
            q.addLast(i);
        }
        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length;i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}
