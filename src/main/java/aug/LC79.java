package aug;
import java.util.*;

public class LC79 {
    boolean flag = false;
    boolean[][] visit;
    int[] directX = new int[]{1,-1,0,0};
    int[] directY = new int[]{0,0,1,-1};
    public void fnc(char[][] board, String word,int m,int n,int index){
        visit[m][n] = true;
        if(index == word.length()-1){
            flag = true;
            return;
        }
        for(int i=0; i<4;i++){
            int x = m+directX[i];
            int y = n+directY[i];
            if(x>=0&&x<board.length&&y>=0&&y<board[0].length&&!visit[x][y]&&word.charAt(index+1) == board[x][y]){
                fnc(board,word,x,y,index+1);
                if(flag) return;
            }
        }
        visit[m][n] = false;
    }
    public boolean exist(char[][] board, String word) {
        visit = new boolean[board.length][board[0].length];
        char s = word.charAt(0);
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(s == board[i][j]){
                    fnc(board,word,i,j,0);
                    if(flag) return true;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        char[][] board = new char[3][3];
        board[0] = new char[]{'b','a','b'};
        board[1] = new char[]{'b','b','a'};
        board[2] = new char[]{'b','b','b'};
        LC79 lc79 = new LC79();
        lc79.exist(board,"ab");
    }
}
