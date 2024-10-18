package _24oct;

public class MST1714 {
    public void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    // 普通快速排序 没用随机数
    // 随机快速排序
    // 随机快速排序-优化

    // 时间复杂度，不用随机数，最坏 1,2,3,4,5,6,7 每次都选最后一个数作为基准

    public void fnc(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        sort1(nums, l, r);
    }

    public void sort1(int[] nums, int l, int r) {
        // 1判断区间合法性
        if (l >= r) return;
        // 2(随机数)
        int x = nums[l + (int) ((r - l + 1) * Math.random())];
        // 3划分
        int mid = partition(nums, l, r, x);
        // 4递归调用
        sort1(nums, l, mid - 1);
        sort1(nums, mid + 1, r);
    }

    public int partition(int[] nums, int l, int r, int x) {
        // 划分过程 一个a,一个i
        // 一个xi记录等于x的位置
        // a左边是小于等于x的
        // i是自增的
        // nums[i] <= x,找到了一个小于等于x的，和a的位置swap
        // a++ 代表小于等于x的范围增加
        // 否则只有i++;
        int a = l;
        int xi = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] <= x) {
                swap(nums, a, i);
                if (nums[a] == x) {
                    xi = a;
                }
                a++;
            }
        }
        // 找一个等于x的处于小于等于x范围的最右边也就是a-1的位置
        swap(nums, a - 1, xi);
        // a左边都是小于等于x的，a-1等于x,从a开始都是大于x的
        return a - 1;
    }

    public static void main(String[] args) {
        MST1714 mst1714 = new MST1714();
        int[] nums = new int[]{5, 4, 3, 2, 1};
        mst1714.sort1(nums, 0, 4);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
