package bishi.hw;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class _0417_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 阈值
        int m = scanner.nextInt();
        // 行数
        int n = scanner.nextInt();
        scanner.nextLine();
        // 存储父节点
        HashMap<String, String> map1 = new HashMap<>();
        // 存储值
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i=0; i<n; i++){
            String[] split = scanner.nextLine().split(" ");
            if (Objects.equals(split[1],"*")){
                map1.put(split[0],null);
            }else {
                map1.put(split[0],split[1]);
            }
            String root = split[0];
            while (map1.get(root) != null){
                root = map1.get(root);
            }
            int num ;
            // 严重问题
            if (Integer.parseInt(split[2]) == 0 ){
                num = 5*Integer.parseInt(split[3]);
            }else {
                num = 2*Integer.parseInt(split[3]);
            }
            map2.put(root,map2.getOrDefault(root,0)+num);

        }

        long count = map2.entrySet().stream().filter(entry -> entry.getValue() > 40).count();

        System.out.println(count);

    }
}
