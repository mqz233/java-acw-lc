package bishi.ali;

import org.junit.Test;

import java.util.HashSet;
import java.util.Scanner;

public class _0316_2 {

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        // set
        HashSet<Character> c = new HashSet<>();
        c.add('a');
        c.add('e');
        c.add('i');
        c.add('o');
        c.add('u');

        // 元音辅音个数
        int yNum = 0;
        int fNum = 0;

        // result
        int result = 0;

        // 统计元音辅音个数
        for (int i=0;i<str.length();i++){
            if (c.contains(str.charAt(i))){
                yNum++;
            }else{
                fNum++;
            }
        }

        int leftY=0;
        int leftF=0;
        int rightY = yNum;
        int rightF = fNum;
        for (int i=0;i<str.length();i++){
            if (c.contains(str.charAt(i))){
                leftY++;
                rightY--;
            }else{
                leftF++;
                rightF--;
            }
            if (Math.abs(leftF-leftY)==Math.abs(rightF-rightY)){
                result++;
            }


        }

        System.out.println(result);

    }
}
