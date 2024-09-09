package _24sep;

public class LCR076 {
    public int findKthLargest(int[] nums, int k) {
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[i] = nums[i];
        }
        int index = (k/2) - 1;
        for(int i=index;i>=0;i--){
            adjust(arr,i,k);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>arr[0]){
                arr[0] = nums[i];
                adjust(arr,0,k);
            }
        }

        return arr[0];

    }

    public void adjust(int[] nums,int index,int length){
        int min = index;
        int l = 2*index+1;
        int r = 2*index+2;
        if(l<length&&nums[l]<nums[min]){
            min = l;
        }
        if(r<length&&nums[r]<nums[min]){
            min = r;
        }
        if(min != index){
            swap(nums,min,index);
            adjust(nums,min,length);
        }
    }

    public void swap(int[] nums,int i1,int i2){
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    public static void main(String[] args) {
        LCR076 lcr076 = new LCR076();
        lcr076.findKthLargest(new int[]{7,6,5,4,3,2,1},5);
    }
}
