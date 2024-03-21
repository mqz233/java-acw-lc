package bishi.xiaomi;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class XiaoMi_0312_01 {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int pLength = scanner.nextInt();
        // 记录偏爱字符
        HashSet<Character> pSet = new HashSet<>();
        for (int i = 0; i < pLength; i++) {
            pSet.add(scanner.next().charAt(0));
        }
        // 记录偏爱字符位置
        ArrayDeque<Integer> location = new ArrayDeque<>();
        // 记录待处理字符串
        String tmp = scanner.next();
        char[] str = tmp.toCharArray();
        for (int i = 0; i < length; i++) {
            // 偏爱字符
            if (pSet.contains(str[i])) {
                location.addLast(i);
            }
        }
        int start = location.removeFirst();
        if (start != 0) {
            Arrays.fill(str, 0, start, str[start]);
        }
        // 不断替换两个偏爱字符之间的字符
        while (location.size() > 0) {
            int end = location.removeFirst();
            int mid = (start + end) / 2;
            Arrays.fill(str, start, mid+1, str[start]);
            Arrays.fill(str, mid + 1, end+1, str[end]);
            start = end;
        }
        if (start != length - 1) {
            Arrays.fill(str, start, length, str[start]);
        }
        System.out.println(str);
    }

    @Test
    public void test2() {
        char[] str = {'a', 'b', 'e'};
        Arrays.fill(str, 0, 2, str[0]);
        System.out.println(str);

    }
}
