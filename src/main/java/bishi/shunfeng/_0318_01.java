package bishi.shunfeng;

import org.junit.Test;

import java.util.Scanner;

public class _0318_01 {
    public static void main(String[] args) {

    }

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        // type
        String type = scanner.next();
        // type failNum
        int failNum = scanner.nextInt();
        // time
        int time = scanner.nextInt();

        if (type.charAt(0) == 'a'){
            int remains = time - (failNum) - 3;
            int max = (remains / 2) + failNum;
            int min = (remains / 3) + failNum;
            System.out.print(max);
            System.out.print(" ");
            System.out.print(min);

        } else if (type.charAt(0) == 'b') {
            int remains = time - (failNum*2) - 3;
            int max = remains  + failNum;
            int min = (remains / 3) + failNum;
            System.out.print(max);
            System.out.print(" ");
            System.out.print(min);
        } else {
            int remains = time - (failNum*3) - 3;
            int max = remains  + failNum;
            int min = (remains / 2) + failNum;
            System.out.print(max);
            System.out.print(" ");
            System.out.print(min);
        }
    }




}
