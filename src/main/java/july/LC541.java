package july;

/**
 * @Desc：给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class LC541 {
    public void reverse(char[] s,int l,int r){
        while(l<r){
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }

    public String reverseStr(String s, int k) {
        int index = 0;
        char[] arr = s.toCharArray();
        while(index + 2*k <= s.length()){
            reverse(arr,index,index+k-1);
            index = index + 2*k;
        }
        if (index+k<=s.length()){
            reverse(arr,index,index+k-1);

        }else{
            reverse(arr,index,s.length()-1);

        }
        return new String(arr);

    }
}
