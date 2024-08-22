package _24aug;
import java.util.*;

public class LC207 {
    boolean res = true;
    int[] status;
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 节点状态，0代表未开始搜索，1代表搜索中，2代表搜索完毕
        status = new int[numCourses];
        // map 记录节点之间的相连关系
        for(int i=0;i<prerequisites.length;i++){
            ArrayList<Integer> list = map.getOrDefault(prerequisites[i][0], new ArrayList<>());
            list.add(prerequisites[i][1]);
            map.put(prerequisites[i][0],list);
        }

        for(int i=0;i<numCourses;i++){
            if(status[i] == 0){
                fnc(i);
                if(!res){
                    return res;
                }
            }
        }

        return res;
    }

    public void fnc(int index){
        ArrayList<Integer> list = map.getOrDefault(index,null);
        // 没有相连的节点，状态直接改为2
        if(list == null){
            status[index] = 2;
            return;
        }
        // 开始搜索->搜索中
        status[index] = 1;
        for(int i=0;i<list.size();i++){
            int tmp = list.get(i);
            // 相连节点未搜索，那么开始搜索
            if(status[tmp] == 0){
                fnc(tmp);
            }// 相连节点搜索中，说明成环了，失败
            else if(status[tmp] == 1){
                res = false;
                break;
            }
            // 相邻节点搜索过了，直接跳过
            if(!res){
                break;
            }
        }
        status[index] = 2;
    }

    public static void main(String[] args) {
        LC207 lc207 = new LC207();
        int[][] arr = new int[2][2];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;
        lc207.canFinish(2,arr);
    }
}
