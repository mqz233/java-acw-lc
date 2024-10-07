package _24oct;
import java.util.*;

public class LC765 {

    public int[] arr;

    public int find(int x) {
        if (arr[x] != x) {
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }

    public void union(int x, int y) {
        int v1 = find(x);
        int v2 = find(y);
        if (v1 == v2)
            return;
        arr[v1] = v2;
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < 2 * n; i = i + 2) {
            int a1 = row[i] / 2;
            int a2 = row[i + 1] / 2;
            if (a1 != a2) {
                union(a1, a2);
            }
        }
        for (int i = 0; i < n; i++) {
            find(i);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            res = res + (map.get(key) - 1);
        }
        return res;
    }
}

