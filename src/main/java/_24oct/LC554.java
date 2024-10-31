package _24oct;
import  java.util.*;

public class LC554 {
    boolean find(List<Integer> arr,int target,int l,int r){
        if(l>r) return false;
        int mid = l + ((r-l)>>1);
        if(arr.get(mid) == target) return true;
        else if(arr.get(mid)<target){
            return find(arr,target,mid+1,r);
        }else{
            return find(arr,target,l,mid-1);
        }

    }
    public int leastBricks(List<List<Integer>> wall) {
        // 求每一行的前缀和数组
        // 二分查找，不存在那么count++;
        int sum = -1;
        for(int i=0;i<wall.size();i++){
            List<Integer> tmp = wall.get(i);
            int cur = 0;
            for(int j=0;j<tmp.size();j++){
                cur += tmp.get(j);
                tmp.set(j,cur);
                if(sum == -1 && j == tmp.size()-1){
                    sum = cur;
                }
            }
            wall.set(i,tmp);
        }
        int res = Integer.MAX_VALUE;
        for(int i=1;i<sum;i++){
            int count = 0;
            for(int j=0;j<wall.size();j++){
                List<Integer> tmp = wall.get(j);
                if(tmp.size() == 1){
                    count++;
                    continue;
                }
                boolean flag = find(tmp,i,0,tmp.size()-1);
                if(!flag) count++;
            }
            res = Math.min(res,count);
        }
        return res;
    }

    public static void main(String[] args) {
        LC554 lc554 = new LC554();
        List<List<Integer>> wall = new ArrayList<>();
//        List<Integer> tmp = new ArrayList<>();
//        tmp.add(1);
//        tmp.add(2);
//        tmp.add(2);
//        tmp.add(1);
//        wall.add(tmp);
//        List<Integer> tmp1 = new ArrayList<>();
//        tmp1.add(3);
//        tmp1.add(1);
//        tmp1.add(2);
//        wall.add(tmp1);
//        List<Integer> tmp2 = new ArrayList<>();
//        tmp2.add(1);
//        tmp2.add(3);
//        tmp2.add(2);
//        wall.add(tmp2);
//        List<Integer> tmp3 = new ArrayList<>();
//        tmp3.add(2);
//        tmp3.add(4);
//        wall.add(tmp3);
//        List<Integer> tmp4 = new ArrayList<>();
//        tmp4.add(3);
//        tmp4.add(1);
//        tmp4.add(2);
//        wall.add(tmp4);
//        List<Integer> tmp5 = new ArrayList<>();
//        tmp5.add(1);
//        tmp5.add(3);
//        tmp5.add(1);
//        tmp5.add(1);
//        wall.add(tmp5);

        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        wall.add(tmp);
        List<Integer> tmp1 = new ArrayList<>();
        tmp1.add(1);
        wall.add(tmp1);
        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(1);
        wall.add(tmp2);
        lc554.leastBricks(wall);
    }
}

