package test;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int tSize = scanner.nextInt();
        int[][] map = new int[num][tSize+2];
        Integer[] arr = new Integer[num];
        for (int i=0;i<num;i++){
            arr[i] = i;
            String tmp = scanner.next();
            int count = 0;
            int max = 0;
            int lSize = 0;
            int k=0;
            for (int j=0; j<tSize;j++){
                if (tmp.charAt(j) == '1'){
                    count++;
                    lSize++;
                    if (lSize>max){
                        max = lSize;
                    }
                }else {
                    lSize = 0;
                    map[i][2+k] = j;
                    k++;
                }
            }
            map[i][0] = count;
            map[i][1] = max;
        }
        Arrays.sort(arr,(a,b)->{
            // 比较进球数
            if (map[a][0]>map[b][0]){
                return -1;
            }
            if (map[a][0]<map[b][0]){
                return 1;
            }

            // 比较连续进球数
            if(map[a][1]>map[b][1]){
                return -1;
            }
            if (map[a][1]<map[b][1]){
                return 1;
            }

            // 比较失球顺序
            for (int i=2;i<tSize+2;i++){
                if (map[a][i]<map[b][i]){
                    return 1;
                }
                if (map[a][i]>map[b][i]){
                    return -1;
                }
            }

            return Integer.compare(a,b);
        });

        for (int i=0;i<num;i++){
            System.out.print(arr[i]+1);
            if (i!=num-1){
                System.out.print(' ');
            }
        }
    }

}
