/*
* k * K크기의 정사각형 중 최대가 되도록 -> 누적합
* 정사각형 최대 총합: 500*500*100 =>25000000 -> Int
*/

import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    private static int[][] nums;
    private static int[][] presums;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        solve();
    }

    private static void solve() {
        int max = 0;
        for (int i=k; i<=n; i++) {
            for (int j=k; j<=n; j++) {
                int kBlock = presums[i][j] - presums[i-k][j] - presums[i][j-k] + presums[i-k][j-k];
                max = Math.max(max, kBlock);
            }
        }
        System.out.println(max);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nums = new int[n+1][n+1];
        presums = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j=1; j<=n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                presums[i][j] = presums[i][j-1] + presums[i-1][j] - presums[i-1][j-1] + nums[i][j]; 
            }
        }
    }
}