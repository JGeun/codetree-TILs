import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> data = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String color = br.readLine();
            data.put(color, data.getOrDefault(color, 0) + 1);
        }

        List<String> dataKeyList = new ArrayList<>(data.keySet());
        int res = 0;
        for (String key : dataKeyList) {
            res = Math.max(res, data.get(key));
        }

        System.out.println(res);
    }
}