package carl.deque;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key:
                map.keySet()
        ) {
            if (queue.size()<k){
                queue.add(key);
            }
            else {
                if (map.get(key)>map.get(queue.peek())){
                    queue.remove();
                    queue.add(key);
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove();
        }

        return res;

    }
}
