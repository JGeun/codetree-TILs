import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static String[] words;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        solve();
    }

    private static void solve() {
        HashMap<String, Integer> store = new HashMap<>();

        for (String word : words) {
            char[] chArr = word.toCharArray();
            Arrays.sort(chArr);

            String sortedStr = new String(chArr);
            store.put(sortedStr, store.getOrDefault(sortedStr, 0) + 1);
        }
        
        int max = 0;
        for (String key : store.keySet()) {
            max = Math.max(max, store.get(key));
        }

        System.out.println(max);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        words = new String[n];
        for (int i=0; i<n; i++) {
            String word = br.readLine();
            words[i] = word;
        }
    }
}