import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int data : arr) {
            map.put(data, map.getOrDefault(data, 0) + 1);
        }

        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            pq.offer(new Data(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(pq.poll().getNum());

            if (i != k -1) {
                sb.append(' ');
            }
        }
        System.out.println(sb.toString());
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

class Data implements Comparable<Data> {
    private int num, cnt;

    public Data(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

    public int getNum() {
        return num;
    }
    
    public int getCnt() {
        return cnt;
    }

    @Override
    public int compareTo(Data d) {
        if (this.cnt > d.getCnt()) return -1;
        else if (this.cnt < d.getCnt()) return 1;
        else {
            if (this.num > d.getNum()) return -1;
            else if (this.num < d.getNum()) return 1;
            return 0;
        } 
    }
}