package carl.string;

public class KMP {
    public int[] buildNext(String str){
        int prefix_len = 0;
        int[] next = new int[str.length()];
        next[0] = 0;
        int index=1;
        while (index<str.length()){
            // 匹配成功
            if (str.charAt(index) == str.charAt(prefix_len)){
                prefix_len++;
                next[index] = prefix_len;
                index++;

            }
            // 公共前后缀长度变为0
            else if (prefix_len == 0){
                next[index] = 0;
                index++;
            }
            // 公共前后缀长度不为0
            else {
                prefix_len = next[prefix_len-1];
            }
        }
        return next;
    }

    public int kmp(String str, String pattern){
        // build next
        int[] next = buildNext(pattern);
        // 开始匹配 i为pattern index j为str index
        // pattern一遍过，j的index不断回溯
        int i=0;
        int j=0;
        while (i<pattern.length()){
            // 匹配成功都+1
            if (pattern.charAt(i) == str.charAt(j)){
                i++;
                j++;
            }
            // 回到str开头了，pattern index++
            else if (next[j-1] == 0){
                i++;
            }
            // 找到回溯位置
            else {
                j = next[j-1];
            }

            // 匹配结束
            if (j == str.length()){
                return i-j;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // test
        KMP kmp = new KMP();
        System.out.println(kmp.kmp("abcabc","abcababcabc"));
    }

}
