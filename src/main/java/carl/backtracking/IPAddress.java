package carl.backtracking;

import java.util.ArrayList;
import java.util.List;

public class IPAddress {
    private final List<String> res = new ArrayList<>();
    private final StringBuilder ip = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return res;
    }

    void backtracking(String s, int index, int count) {

        // 这个起始数字不能大于2，也不能等于0
        // 有错误
        if ((int) s.charAt(index) > 2 || (int) s.charAt(index) == 0) {
            return;
        }
        // (纵向)最多切3次,判断剩余字符串长度
        if (count==3&&s.length()-index<=3){
            res.add(ip.substring(0,ip.length()-1));
            return;
        }
        //横向，确定切分点
        for (int i = index; i < index + 3; i++) {
            ip.append(s, index, i+1);
            ip.append(".");
            count = count +1;
            backtracking(s,i+1,count);
            count = count - 1;
            ip.delete(ip.length()-(i-index+2),ip.length());
        }

    }

}
