package bishi.pdd;
import java.util.*;


public class _0509_2 {
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        for (int i=0; i<num;i++){
            String[] split = in.nextLine().split(" ");
            String s = in.nextLine();
            int sum=0;
            if (Integer.parseInt(split[1]) == 0){
                for (int j=0;j<s.length()-1;j++){
                    sum+=Integer.parseInt(String.valueOf(s.charAt(j)) + s.charAt(j + 1));
                }
            }else{
                int end = s.length()-1;
                int start = 0;
                int step = Integer.parseInt(split[1]);
                StringBuilder sb = new StringBuilder(s);
                while (end>=0&&sb.charAt(end)!='1'){
                    end--;
                }
                // 右侧移动到最右边
                if (step>=sb.length()-1-end){
                    step -= (sb.length()-1-end);
                    sb.replace(end,end+1,"0");
                    sb.replace(sb.length()-1,sb.length(),"1");
                }
                while (start<=sb.length()-1&&sb.charAt(start)!='1'){
                    start++;
                }
                // 左侧移动到最左边
                if (step>=start){
                    step -= start;
                    sb.replace(start,start+1,"0");
                    sb.replace(0,1,"1");
                }
                // 把其他的右边往右边移动
                while (start>=end&&step>0){
                    if (sb.charAt(end) == '1'&& end+1<sb.length()&&sb.charAt(end+1)=='0'&&end-1>=0&&sb.charAt(end-1)=='1'){
                        step--;

                        sb.replace(end,end+1,"0");
                        sb.replace(end+1,end+2,"1");
                    }
                    end--;

                }
                for (int j=0;j<sb.length()-1;j++){
                    sum+=Integer.parseInt(String.valueOf(sb.charAt(j)) + sb.charAt(j + 1));
                }
            }
            System.out.println(sum);

//            1
//            9 6
//            1
//            4
//            7
//            1
//            3
//            6
//            8
//            10
//            9







        }

    }
}
