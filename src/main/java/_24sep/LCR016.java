package _24sep;

public class LCR016 {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        boolean[] arr = new boolean[128];
        while(r<s.length()){
            if(!arr[s.charAt(r)]){
                max = Math.max(max,r-l+1);
                arr[s.charAt(r)] = true;
                r++;
            }else{
                while(s.charAt(l) != s.charAt(r)){
                    arr[s.charAt(l)] = false;
                    l++;

                }
                l++;
                r++;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        LCR016 lcr016 = new LCR016();
        lcr016.lengthOfLongestSubstring("pwwkew");
    }
}
