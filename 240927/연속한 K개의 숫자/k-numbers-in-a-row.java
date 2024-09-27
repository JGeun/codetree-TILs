import java.util.*;
import java.io.*;

/**
 *
 * 이 문제는 구간합을 통해 해당 세트에 포함되는 숫자들을 몇개 가지고 있는지를 저장하는 배열을 가지고
 * 찾는 문제입니다.
 */
public class Main {
    private static int N, K, B;
    private static HashSet<Integer> map;
    private static int[] presums;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        solve();
    }

    private static void solve() {
        int min = K;

        for (int i=K; i<=N; i++) {
            min = Math.min(min, presums[i] - presums[i-K]);
        }
        
        System.out.println(min);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new HashSet<>();

        for (int i=0; i<B; i++) {
            int num = Integer.parseInt(br.readLine());
            map.add(num);
        }

        presums = new int[N+1];
        
        for (int i=1; i<=N; i++) {
            presums[i] = presums[i-1] + (map.contains(i) ? 1 : 0);
        }
    }
}