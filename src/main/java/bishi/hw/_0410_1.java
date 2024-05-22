package bishi.hw;

import java.util.HashMap;
import java.util.Scanner;

public class _0410_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] tmp = new String[n];
        for (int i=0; i<n;i++){
            tmp[i] = scanner.nextLine();
        }
        // m
        int m= scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<m; i++){
            String[] split = scanner.nextLine().split(",");
            map1.put(split[0],Integer.parseInt(split[1]));
        }

        for (int i=0; i<n; i++){
            String[] split = tmp[i].split(",");
            map2.put(split[1],map2.getOrDefault(split[1],0)+map1.get(split[2])*Integer.parseInt(split[3]));
        }

        for (String key: map2.keySet()){
            System.out.println(key+","+map2.get(key));
        }

    }
}


