package test;

import java.math.BigInteger;

public class Test043 {

    public static String subtract(String num1, String num2) {
        // 确保num1是较大的数
        if (num1.length() < num2.length() || (num1.length() == num2.length() && num1.compareTo(num2) < 0)) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
            return "-" + subtract(num2, num1); // 如果num1小于num2，则交换并返回负值
        }

        StringBuilder result = new StringBuilder();
        int borrow = 0; // 借位

        // 从字符串末尾开始逐位相减
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0; i--, j--) {
            int digit1 = j < 0 ? 0 : num2.charAt(j) - '0'; // 如果num2较短，则补0
            int digit2 = num1.charAt(i) - '0';

            int diff = digit2 - digit1 - borrow;

            if (diff < 0) {
                diff += 10; // 需要从高位借位
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.insert(0, diff);
        }

        // 去除结果前导0
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        String num1 = "12345678901234567890";
        String num2 = "9876543210987654321";
        System.out.println(subtract(num1, num2));
        System.out.println(new BigInteger(num1).subtract(new BigInteger(num2)));// 输出结果
    }
}