package test;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> tmp = new ArrayList<>();
        int m = 0;
        int n = 0;
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.isEmpty()) break;
            String[] arr = s.substring(1,s.length()-1).split(",");
            List<Integer> list = new ArrayList<>();
            n = arr.length;
            for(int i=0;i<arr.length;i++){
                list.add(Integer.parseInt(arr[i]));
            }
            tmp.add(list);
            m++;
        }
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++) {
            List<Integer> integers = tmp.get(i);
            for (int j = 0; j < n; j++) {
                arr[i][j] = integers.get(j);
            }
        }

        System.out.printf("");
    }
}
