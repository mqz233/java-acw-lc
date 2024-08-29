package _24aug;

public class LC215 {
    public void adjust(int[] nums,int index,int length){
        // 下一个要调整的位置
        int next = index;
        int max = nums[index];
        if(2*index+1<length && nums[2*index+1]>max){
            max = nums[2*index+1];
            next = 2*index+1;
        }

        if(2*index+2<length && nums[2*index+2]>max){
            max = nums[2*index+2];
            next = 2*index+2;
        }
        if(next!=index){
            swap(nums,index,next);
            adjust(nums,next,length);
        }
    }

    public void swap(int[] nums,int i1,int i2){
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
    public int findKthLargest(int[] nums, int k) {
        // 建大顶堆
        int length = nums.length;
        int start = length/2 - 1;
        for(int i=start;i>=0;i--){
            adjust(nums,i,length);
        }
        // 删除k-1次，获得堆顶元素
        for(int i=1;i<=k-1;i++ ){
            swap(nums,0,length-i);
            adjust(nums,0,length-i);
        }
        return nums[0];
    }

    public int findKthLargest2(int[] nums, int k) {
        // 桶排序 如何找第k大的
        // 前提数据的范围不大 10(-4) - 10(4)
        int[] arr = new int[20001];
        for(int i=0; i<nums.length;i++){
            arr[nums[i]+10000] += 1;
        }

        for(int i=20000;i>=0;i--){
            k = k - arr[i];
            if(k<=0){
                return i-10000;
            }
        }

        return 0;
    }
}
