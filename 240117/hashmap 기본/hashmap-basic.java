import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<Integer, String> data = new HashMap<>();

        while(n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String command = st.nextToken();
            switch(command) {
                case "add":
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    data.put(a, b+"");
                    break;
                case "find":
                    int findValue = Integer.parseInt(st.nextToken());
                    String msg = data.getOrDefault(findValue, "None");
                    System.out.println(msg);
                    break;
                case "remove":
                    int removeValue = Integer.parseInt(st.nextToken());
                    data.remove(removeValue);
                    break;
            }
        }
    }
}