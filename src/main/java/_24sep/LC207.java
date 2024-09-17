package _24sep;

public class LC207 {
    public boolean fnc(boolean[][] map,int i1,int[] arr){
        arr[i1] = 1;
        for(int i=0;i<map[0].length;i++){
            if(map[i1][i]){
                if(arr[i] == 0){
                  boolean flag =  fnc(map,i,arr);
                  if(!flag) return false;
                }else if(arr[i] == 1){
                    return false;
                }
            }
        }
        arr[i1] = 2;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 2 [[1,0],[0,1]]
        int[] arr = new int[numCourses];
        boolean[][] map = new boolean[numCourses][numCourses];
        for(int i=0;i<prerequisites.length;i++){
            map[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        for(int i=0;i<numCourses;i++){
            if(arr[i] == 0){
             boolean flag =   fnc(map,i,arr);
             if(!flag) return false;
            }
        }

        return true;


    }

    public static void main(String[] args) {
        LC207 lc207 = new LC207();
        lc207.canFinish(2,new int[][]{new int[]{1,0},new int[]{0,1}});
    }
}
