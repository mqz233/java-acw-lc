package carl.greedy;

public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }
        int prediff = 0;
        int curdiff = 0;
        // 长度大于2，序列长至少为1
        int res = 1;
        for (int i = 0; i < nums.length-1; i++) {
            curdiff = nums[i+1] - nums[i];
            // 判断条件，规定为右边不能平坡，左边可以平坡
            if ((prediff<=0&&curdiff>0)||(prediff>=0&&curdiff<0)){
                res++;
                // prediff只有当出现峰值时再更新，防止因为单调序列中出现平坡导致误判
                prediff = curdiff;
            }
            // 这样就不对 [1,2,2,3,4] 此时结果为3，实际为2
            // prediff = curdiff;
        }
        return res;


    }
}
