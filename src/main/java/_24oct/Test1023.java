package _24oct;

import java.util.Arrays;
import java.util.HashMap;

public class Test1023 {
    public static String[] fnc(String[] names, String[] scores) {
        int n = scores.length;
        int[] arr = new int[n];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tmp = scores[i].split(",");
            int sum = 0;
            for (String s : tmp) {
                sum += Integer.parseInt(s);
            }
            arr[i] = sum;
            map.put(names[i], arr[i]);
        }
        Arrays.sort(names, (a, b) -> map.get(b).compareTo(map.get(a)));
        return names;
    }

    public static void main(String[] args) {
        String[] name = {"王飞","刘洋","李丽"};
        String[] scores = {"89,92,95,88,91","92,96,81,90,92","89,91,91,78,97"};
        fnc(name,scores);
    }
}
