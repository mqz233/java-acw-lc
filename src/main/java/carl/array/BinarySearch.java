package carl.array;

public class BinarySearch {
    public static void main(String[] args) {

        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 2));

    }

    public int search(int[] nums, int target) {

        // left
        int left = 0;
        // right
        int right = nums.length - 1;

        // 等号成立，因为得到新值还未判断
        while (left <= right) {

            // 下标 用减法避免溢出
            int index = (right - left) / 2 + left;

            if (target == nums[index]) {
                return index;
            } else if (target > nums[index]) {
                left = index + 1;
            } else {
                right = index - 1;
            }


        }

        return -1;

    }

}

