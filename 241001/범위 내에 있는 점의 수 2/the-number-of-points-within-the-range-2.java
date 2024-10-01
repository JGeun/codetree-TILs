import java.util.*;
import java.io.*;

/**
 * 
 */
public class Main {
    private static int N, Q;
    private static int MAX_RANGE = 1000001;
    private static int[] points;
    private static int[] dists;
    private static int[] presums;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        points = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        dists = new int[MAX_RANGE];
        presums = new int[MAX_RANGE];

        for (int point : points) {
            dists[point] += 1;
        }        

        for (int i=1; i<dists.length; i++) {
            presums[i] = presums[i-1] + dists[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(presums[end] - presums[start-1]).append("\n");
        }

        System.out.println(sb);
    }
}