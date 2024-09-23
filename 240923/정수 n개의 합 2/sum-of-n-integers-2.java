/*
 * 
 *
 */
import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        solve();
    }

    private static void solve() {
        int startSum = 0;
        for (int i=0; i<k; i++) {
            startSum += nums[i];
        }

        int result = 0;
        int[] preSums = new int[n-k+1];
        for (int i=0; i<n-k; i++) {
            preSums[i] = startSum;
            startSum = startSum + nums[i+k] - nums[i];
            result = Math.max(preSums[i], result);
        }

        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}