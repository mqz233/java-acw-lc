package _24oct;

public class LC839 {

    int[] arr;

    public boolean check(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 2) return false;
        }
        return true;
    }

    public int find(int x) {
        if (arr[x] != x) {
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }

    public void union(int x, int y) {
        if (find(x) != find(y)) {
            arr[find(x)] = arr[find(y)];
        }
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (check(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == find(i)) {
                count++;
            }
        }
        return count;

    }
}

