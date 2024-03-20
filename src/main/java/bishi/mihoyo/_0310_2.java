package bishi.mihoyo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class _0310_2 {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        Scanner scanner = new Scanner(System.in);
        // 奖品总数
        int rewards = scanner.nextInt();
        // 特殊规则
        int rule = scanner.nextInt();
        // 事件个数
        int num = scanner.nextInt();
        // 队列记录排队人员
        ArrayDeque<String> persons = new ArrayDeque<>();
        HashMap<String, Integer> personsMoney = new HashMap<>();
        // 模拟流程
        for (int i = 0; i < num; i++) {
            int tmp = scanner.nextInt();
            if (tmp == 1) {
                String name = scanner.next();
                persons.addLast(name);
                if (!personsMoney.containsKey(name)) {
                    personsMoney.put(name, 0);
                }
            } else if (tmp == 2) {
                persons.remove(scanner.next());
            } else if (tmp == 3) {
                String cur = persons.getFirst();
                int m = scanner.nextInt();
                rewards = rewards - m;
                if (rewards <= rule) {
                    personsMoney.put(cur, rewards + m);
                    break;
                } else {
                    personsMoney.put(cur, m);
                }

            } else {
                System.out.println(persons.size());
            }

        }
        // 根据首字母获得排序
        List<String> collect = personsMoney.keySet().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        for (String name : collect) {
            System.out.println(name + " " + personsMoney.get(name).toString());
        }

    }

    @Test
    public void test2() {
        Set<String> set = new HashSet<>();
        set.add("Mona");
        set.add("Kaveh");
        System.out.println(set.toString());
        //这里后续用有序的list处理即可，因为流中进行了倒序处理，收集成set后会重排
        List<String> collect = set.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(collect);

    }

}
