import java.util.*;
import java.io.*;

public class Main {
    private static final int MAX_N = 100;

    private static int n, m;
    private static int[][] graph = new int[MAX_N+1][MAX_N+1];
    private static boolean[] visited = new boolean[MAX_N+1];
    private static int[] dist = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        input();
        solve();
    }

    private static void solve() {
        for (int i=1; i<=n; i++) {
            int minIndex = -1;
            for (int j=1; j<=n; j++) {
                if (visited[j]) continue;

                if (minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j =1; j<=n; j++) {
                if (graph[minIndex][j] == 0) continue;

                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }

        for(int i = 2; i <= n; i++) {
            if(dist[i] == (int)1e9)
                System.out.println(-1);
            else
                System.out.println(dist[i]);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from][to] = weight;
        }

        for(int i = 1; i <= n; i++)
            dist[i] = (int)1e9;

        dist[1] = 0;
    }
}