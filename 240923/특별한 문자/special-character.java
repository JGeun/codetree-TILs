/**
 * 단 한번만 등장하는 문자 찾기 -> HashMap에 저장하고 1인 것 만나면 출력
 * 여러개면 가장 먼저 등장한 문자를 기준으로 출력이기 때문에 정렬이 필요함.
 */
import java.util.*;
import java.io.*;

public class Main {
    private static String word;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        solve();
    }

    private static void solve() {
        char[] chArr = word.toCharArray();
        Arrays.sort(chArr);
        LinkedHashMap<Character, Integer> storeMap = new LinkedHashMap<>();

        for (char ch : chArr) {
            storeMap.put(ch, storeMap.getOrDefault(ch, 0) + 1);
        }

        for (char key : storeMap.keySet()) {
            int cnt = storeMap.get(key);
            if (cnt != 1) continue;
            System.out.println(key); 
            break;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
    }
}