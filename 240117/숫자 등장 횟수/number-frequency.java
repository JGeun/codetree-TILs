import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> data = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int key = Integer.parseInt(st.nextToken());
            data.put(key, data.getOrDefault(key, 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(data.getOrDefault(key, 0)).append(' ');
        }

        System.out.println(sb);
    }
}