package _24sep;

public class QuickSort2 {
    public static void main(String[] args) {
        QuickSort2 q = new QuickSort2();
        int[] nums = new int[]{5,4,3,2,1};
        q.sort(nums,0,4);
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
    public void swap(int[] nums,int n1,int n2){
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }
    public void sort(int[] nums,int l,int r){
        if(l>=r) return;
        int num = nums[l];
        int l1 = l;
        int r1 = r;
        while(l1<r1){
            while(l1<r1 && nums[r1]>=num){
                r1--;
            }
            if(l1>=r1){
                break;
            }
            while(l1<r1 && nums[l1]<=num){
                l1++;
            }
            if(l1>=r1){
                break;
            }
            swap(nums,l1,r1);

        }
        swap(nums,l,r1);
        sort(nums,l,r1-1);
        sort(nums,r1+1,r);
    }
}
