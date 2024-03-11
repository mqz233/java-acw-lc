package carl.mstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.cn/problems/next-greater-element-i/description/ 下一个更大元素1
// 单调栈+hash
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // !**! stack存储下标
        // 单调栈 栈底要大于栈顶,入栈时发现比栈顶大,栈顶持续弹出(同时说明找到了距离栈顶元素最近的,更大的值)
        ArrayDeque<Integer> mstack = new ArrayDeque<>();

        // hashMap 元素不重复 key为值 value为下标,进行索引
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums1.length;i++){
            map.put(nums1[i],i);
        }

        // result 结果
        int[] result = new int[nums1.length];

        Arrays.fill(result,-1);

        mstack.addFirst(0);

        // 入栈过程
        for (int i=1; i<nums2.length;i++){
            while (!mstack.isEmpty()&&nums2[i]>nums2[mstack.getFirst()]){

                // 栈顶元素找到了距离它最近的更大元素,出栈
                int tmp = mstack.removeFirst();
                // 尝试在map中寻找
                if (map.containsKey(nums2[tmp])){
                    result[map.get(nums2[tmp])] = nums2[i];
                }
            }
            // 入栈,存储下标
            mstack.addFirst(i);
        }

        return result;

    }
}
