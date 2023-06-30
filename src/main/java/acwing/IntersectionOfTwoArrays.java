package acwing;

import java.util.ArrayList;
import java.util.List;

// 两个数组的交集 哈希表
// https://leetcode.cn/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {

        int N = 1010;
        int[] hset = new int[N];
        List<Integer> resultList = new ArrayList<>();

        for (int u : nums1) {

            if (hset[u] == 0) {
                hset[u]++;
            }
        }
        for (int u : nums2) {

            if (hset[u] == 1) {
                resultList.add(u);
                hset[u]--;
            }

        }

        return resultList.stream().mapToInt(Integer::valueOf).toArray();


    }
}
