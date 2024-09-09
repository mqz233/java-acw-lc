package _24july;

public class LC17_14 {
    public int[] smallestK(int[] arr, int k) {
        build(arr, arr.length);
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = arr[0];
            swap(arr,0,arr.length-1-i);
            adjust(arr,0,arr.length-1-i);
        }
        return res;
    }

    public void build(int[] arr,int length){
        int index = length/2 - 1;
        for(int i=index;i>=0;i--){
            adjust(arr,i,length);
        }
    }

    public void swap(int[] arr,int i1,int i2){
        int  tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public void adjust(int[] arr,int index,int length){
        int l = 2*index+1;
        int r = 2*index+2;
        if(l>=length||r>=length) return;
        int min = index;
        if(arr[l]<arr[min]){
            min = l;
        }
        if(arr[r]<arr[min]){
            min = r;
        }
        if(min!=index){
            swap(arr,index,min);
            adjust(arr,min,length);
        }

    }
}
