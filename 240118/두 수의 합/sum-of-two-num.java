import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        Map<Integer, Integer> data = new HashMap<>();

        int res = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            res += data.getOrDefault((int)(k-num), 0);
            data.put(num, data.getOrDefault(num, 0)+1);
        }
        System.out.println(res);
    }
}