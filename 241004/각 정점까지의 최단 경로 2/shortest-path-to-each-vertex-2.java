import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[][] nodes;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        input();
        solve();
    }

    private static void solve() {
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    nodes[i][j] = Math.min(nodes[i][j], nodes[i][k] + nodes[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                sb.append(nodes[i][j] != (int)1e9 ? nodes[i][j] : -1).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nodes = new int[n+1][n+1];
        for (int i=1; i<nodes.length; i++) {
            Arrays.fill(nodes[i], (int)1e9);
            nodes[i][i] = 0;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[a][b] = Math.min(nodes[a][b], weight);
        }
    }
}