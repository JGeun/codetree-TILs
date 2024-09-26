import java.util.*;
import java.io.*;

/**
 * 정수 최대 값이 1,000,000이므로 1,000,000 * 1,000,000 => 1,000,000,000 => int 범위
 *
 * 1 ~ n까지 돌면서 구간합을 체크하면 됨
 *
 */
public class Main {
    
    private static int n, k;
    private static int[] nums;
    private static int[] presums;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        solve();
    }

    private static void solve() {
        int res = 0;
        for (int i=1; i<=n; i++) {
            for (int j=i; j<=n; j++) {
                res += (presums[j] - presums[j-i]) == k ? 1 : 0;
            }
        }
        System.out.println(res);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nums = new int[n+1];
        presums = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            presums[i] = presums[i-1] + nums[i];
        }
    }

}