/**
 * 동일한 x좌표를 갖는 점들 중 가장 작은 y점들의 합
 */
import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] pos;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        solve();
    }
    
    private static void solve() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] p : pos) {
            if (map.containsKey(p[0])) {
                map.put(p[0], Math.min(map.get(p[0]), p[1]));
            } else {
                map.put(p[0], p[1]);
            }
        }
        
        long res = 0;
        for (int key : map.keySet()) {
            res += map.get(key);
        }
        System.out.println(res);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        pos = new int[n][2];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j=0; j<2; j++) {
                pos[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}