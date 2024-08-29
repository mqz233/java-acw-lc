package _24aug;

import java.util.*;

public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计出现次数
        // 桶排序
        // nums内数字最多出现 nums.length次 这个次数最大为 10(5) 量级，不大，空间换时间
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer>[] lists = new ArrayList[nums.length + 1];
        for (Integer key : map.keySet()) {
            // 次数作为索引，数字作为值
            int count = map.get(key);
            if (lists[count] == null) {
                lists[count] = new ArrayList<>();
            }
            lists[count].add(key);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = lists.length - 1; i >= 1 && k > 0; i--) {
            if (lists[i] != null) {
                res.addAll(lists[i]);
                k -= lists[i].size();
            }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
