package carl.string;

public class ReverseStringII {
    public String reverseStr(String s, int k) {

        int index = 0;
        char[] str = s.toCharArray();
        while (index + 2 * k < s.length()) {
            //交换前k个
            reverse(str,index,index+k-1);
            //向后移动2k
            index = index + 2 * k;
        }
        if (index + k < s.length()) {
            //交换index到index+k
            reverse(str,index,index+k-1);
        } else {
            // 交换index到length-1
            reverse(str,index,s.length()-1);

        }

        return new String(str);

    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}