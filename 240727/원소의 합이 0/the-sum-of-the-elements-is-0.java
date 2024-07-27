// 25,000,000,000
// 25,000,000,000
// 1. A, B 수열과, C, D 수열을 묶어서 2개의 수를 합친 경우의 수들을 나열한다. (25,000,000)
// 2. HashMap을 통해 첫 번째 경우의 수들에 K를 더했을 때 0으로 만들어주는 수가 있는지 2번째 수열에서 체크한다.
import java.util.*;
import java.io.*;

public class Main {
    private static final int SIZE = 4;
    private static int n;
    private static int[][] arr;
    private static Map<Integer, Integer> firstMap = new HashMap<>();
    private static Map<Integer, Integer> secondMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        init();
        solve();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[SIZE][n];

        for (int i=0; i<SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void makeCase(Map<Integer, Integer> map, int[] first, int[] second) {
        for (int num1 : first) {
            for (int num2 : second) {
                int result = num1 + num2;
                map.put(result, map.getOrDefault(result, 0) + 1);
            }
        }
    }

    private static void solve() {
        makeCase(firstMap, arr[0], arr[1]);
        makeCase(secondMap, arr[2], arr[3]);

        int res = 0;
        for (int num : firstMap.keySet()) {
            if (secondMap.containsKey(-num)) {
                res += firstMap.get(num) * secondMap.get(-num);
            }
        }

        System.out.println(res);
    }
}