package carl.array;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(        new RemoveElement().removeElement(new int[]{3,2,2,3},3)
        );
    }

    public int removeElement(int[] nums, int val) {

        int sum = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                sum++;
            }
            else {
                nums[index] = nums[i];
                index++;
            }
        }

        return nums.length - sum;
    }
}
