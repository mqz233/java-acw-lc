package bishi.pdd;
import java.util.*;


public class _0509_1 {
//    3
//            100 0
//            20 18
//            5 3

    // 10 汉堡价格
    // 5个人 汉堡价格变成5
    // 3个人
    // 5 10-3 = 7
    // 3 15
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i< num; i++){
            String[] split = scanner.nextLine().split(" ");
            int f = Integer.parseInt(split[1]);
            int bal = Integer.parseInt(split[0]);
            int buyNum = 0;
            int totalMoney = 0;
            // 以5元够买的数量
            while (f>=5){
                // 钱必须大于等于5
                if (bal>=5){
                    buyNum++;
                    totalMoney = totalMoney + 5;
                    bal -= 5;
                    f-=5;
                }else {
                    break;
                }
            }
            // 5 - 10购买一个
            if (f>0 && bal>=(10-f)){
                buyNum++;
                totalMoney = totalMoney + 10 - f;
                bal = bal - (10 -f);
            }
            while (bal>=10){
                bal -= 10;
                buyNum++;
                totalMoney += 10;
            }

            System.out.println(buyNum+" "+totalMoney);




        }

    }
}
