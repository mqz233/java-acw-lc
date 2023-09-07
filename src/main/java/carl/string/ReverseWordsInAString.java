package carl.string;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        new ReverseWordsInAString().reverseWords("the sky is blue");
    }

    public String reverseWords(String s) {
        // 去除前后空格
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') {
            left++;
        }
        while (s.charAt(right) == ' ') {
            right--;
        }
        // 开始一个单词一个单词替换。
        StringBuilder result = new StringBuilder();
        int p1 = left;
        while (p1 <= right) {
            if (s.charAt(p1) != ' ') {
                p1++;
            } else {
                result = new StringBuilder(s.substring(left, p1)).append(" ").append(result);
                while (s.charAt(p1) == ' ' && p1 <= right) p1++;
                left = p1;
            }
        }
        result = new StringBuilder(s.substring(left, p1)).append(" ").append(result);

        return result.substring(0, result.length() - 1);

    }
}
