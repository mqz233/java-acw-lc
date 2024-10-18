package _24oct;

public class QuickSort1 {
    public void swap(int[] nums,int i1,int i2){
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
    public void sort(int[] nums,int l,int r){
        if(l>=r) return;
        int p = nums[l + (int)(Math.random()*(r-l+1))];
        int a = l;
        int a1 = l;
        for(int i=l;i<=r;i++){
            if(nums[i]<=p){
                swap(nums,a,i);
                if(nums[a] == p){
                    a1 = a;
                }
                a++;
            }
        }
        swap(nums,a1,a-1);
        sort(nums,l,a-2);
        sort(nums,a,r);
    }

    public static void main(String[] args) {
        QuickSort1 quickSort1 = new QuickSort1();
        int[] nums = new int[]{5, 4, 3, 2, 1};
        quickSort1.sort(nums, 0, 4);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
