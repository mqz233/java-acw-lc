package bishi.quna;
import java.util.*;

public class _quna_0906_01 {
    public static String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        // 将整数数组转化为字符串列表
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }

        // 自定义比较器，用来排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 比较o1 + o2 与 o2 + o1的字典序
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        // 拼接排序后的字符串
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        System.out.println(_quna_0906_01.minNumber(nums)); // 应输出 "3033459"
    }
}