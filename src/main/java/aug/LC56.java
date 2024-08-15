package aug;

import java.util.*;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int r = 1;
        int l = 0;
        // [[1,3],[2,6],[8,10],[15,18]]
        int rValue = intervals[0][1];
        List<List<Integer>> res = new ArrayList<>();
        while (r < intervals.length) {

            while (r < intervals.length && intervals[r][0] <= rValue) {
                rValue = Math.max(intervals[r][1], rValue);
                r++;
            }
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(intervals[l][0]);
            tmp.add(rValue);
            res.add(tmp);
            l = r;
            if (r < intervals.length) {
                rValue = intervals[r][1];

            }
            r = r + 1;

        }
        while (l < intervals.length) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < intervals[l].length; i++) {
                integers.add(intervals[l][i]);
            }
            res.add(integers);
            l++;
        }

        int[][] tRes = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            tRes[i] = res.get(i).stream().mapToInt(t -> t).toArray();
        }
        return tRes;

    }

    public static void main(String[] args) {
        LC56 lc56 = new LC56();
        int[][] merge = lc56.merge(new int[][]{new int[]{1, 4}, new int[]{2, 3}});

        System.out.println("a");

    }
}
