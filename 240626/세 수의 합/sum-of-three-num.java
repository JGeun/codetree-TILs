import java.util.*;
import java.io.*;

// 1초에 n = 1000이라 n^3까지 가능
public class Main {
    private static int n, k;
    private static int[] arr;
    
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        solve();
    }

    private static void solve() {
        int res = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a+1; b < n; b++) {
                for (int c = b+1; c < n; c++) {
                    if (((long)arr[a] + arr[b] + arr[c]) == k) res += 1;
                }
            }
        }
        
        System.out.println(res);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}