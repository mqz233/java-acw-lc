package carl.greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int index = 0;
        while (nums[index] != 0) {
            int maxSteps = 0;
            int nextIndex = 0;
            for (int i = 1; i <= nums[index]; i++) {
                // 可到达的位置已经到达末尾，说明满足要求
                if (index+i >= nums.length - 1){
                    return true;
                }
                // 寻找能到达的最大位置
                if (i + nums[index + i] > maxSteps) {
                    maxSteps = i + nums[index + i];
                    nextIndex = index + i;
                }
            }

            index = nextIndex;
        }

        return false;
    }
}
