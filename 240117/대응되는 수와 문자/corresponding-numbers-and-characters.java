import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> indexMap = new HashMap<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i=1; i<=n; i++) {
            String word = br.readLine();
            wordMap.put(word, i);
            indexMap.put(i, word);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            String find = br.readLine();
            sb.append(Character.isDigit(find.charAt(0)) ? indexMap.get(Integer.parseInt(find)) : wordMap.get(find));
            sb.append('\n');
        }  
        System.out.println(sb);
    }
}