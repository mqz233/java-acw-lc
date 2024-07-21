package july;

/**
 * @description: 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 * 如果不存在这样的子字符串，则返回 0。
 */
public class LC395 {
    // 统计字符个数，找到那些数量小于k的字符
    public int fnc(String s,int k,int l,int r){
        int[] count = new int[26];
        for(int i=l; i<=r;i++){
            count[s.charAt(i)-'a']++;
        }
        // 找到分割点
        int split = -1;
        for(int i=l;i<=r;i++){
            if(count[s.charAt(i)-'a']<k){
                split = i;
                break;
            }
        }
        //找不到说明整个串没问题
        if(split == -1) return r-l+1;
        // 递归右边
        if(split == l){
           return fnc(s,k,l+1,r);
        }else if(split == r){
            return fnc(s,k,l,r-1);
        }else{
            int left = fnc(s,k,l,split-1);
            int right = fnc(s,k,split+1,r);
            return Math.max(left,right);
        }

    }
    public int longestSubstring(String s, int k) {
        int length = s.length();
        return fnc(s,k,0,length-1);
    }
}
