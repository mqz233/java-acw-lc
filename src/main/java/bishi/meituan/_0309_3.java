package bishi.meituan;

import org.junit.Test;

import java.util.Scanner;

public class _0309_3 {
    public static void main(String[] args) {

    }

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        int[] result = new int[n];

        for (int i=0;i<n;i++){
            int tmp=0;
            // j移动行
            for (int j=0;j<=n-i;j++){
                // k移动列
                for (int k=0;k<=n-i;k++){

                }
            }
            tmp=0;
        }
    }

    @Test
    public void test2(){
        Scanner scanner = new Scanner(System.in);
        int N = 510;
        int n = scanner.nextInt();
        char[][] a = new char[N][N];
        int[][] s = new int[N][N];

        for (int i = 1; i <= n; i++) {
            String tmp = scanner.next();
            for (int j = 1; j <= n; j++) {
                a[i][j] = tmp.charAt(j-1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + (a[i][j] == '1' ? 1 : 0);
                System.out.println(s[i][j]);
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int x = 1; x <= n - i + 1; x++) {
                for (int y = 1; y <= n - i + 1; y++) {
                    int sum = s[x + i - 1][y + i - 1] - s[x + i - 1][y - 1] - s[x - 1][y + i - 1] + s[x - 1][y - 1];
                    if (sum * 2 == i * i) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    // 计算前缀和
    @Test
    public void test3(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 计算前缀和，初始化成大一号的
        char[][] a = new char[n+1][n+1];
        int[][] s = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            String tmp = scanner.next();
            for (int j = 1; j <= n; j++) {
                a[i][j] = tmp.charAt(j-1);
            }
        }

        // 计算n*n矩阵的前缀和 https://zhuanlan.zhihu.com/p/117569086
        // 前缀和计算公式 s[i][j] = s[i][j-1]+s[i-1][j]+a[i][j]-s[i-1][j-1]
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                int cur = a[i][j] == '1'?1:0;
                s[i][j] = s[i][j-1]+s[i-1][j]+cur-s[i-1][j-1];
                System.out.println(s[i][j]);
            }
        }

        // 初始化i=1时，result[1]=0
        int[] result = new int[n];
        result[1] = 0;
        // 计算每一个i*i矩阵内的sum，看看是否等于i*i/2
        // int sum = s[j][k]
        // 计算边界条件：举例子最快
        for (int i=2;i<=n;i++){
            for (int j=1;j<=n-i+1;j++){
                for(int k=1;k<=k-i+1;k++){
                    int sum = s[k+i-1][j+i-1]-s[k-1][j+i-1]-s[k+i-1][j-1]+s[k-1][j-1];
                    if (sum*2==i*i){
                        result[i]++;
                    }
                }
            }
        }
    }

}
