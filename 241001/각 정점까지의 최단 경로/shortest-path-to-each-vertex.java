import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, k;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Node>> graph;
    private static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        input();
        solve();
    }

    private static void solve() {
        dist[k] = 0;
        pq.add(new Node(k, 0));

        while (!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if (visited[minIndex]) continue;
            visited[minIndex] = true;

            for (int j=0; j<graph.get(minIndex).size(); j++) {
                int targetIndex = graph.get(minIndex).get(j).index;
                int targetDist = graph.get(minIndex).get(j).dist;

                if (visited[targetIndex]) continue;

                int newDist = dist[minIndex] + targetDist;
                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    
                    pq.add(new Node(targetIndex, newDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            int num = dist[i] != Integer.MAX_VALUE ? dist[i] : -1;
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        for (int i=0; i<=n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        visited = new boolean[n+1];
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        pq = new PriorityQueue<>();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, dist));
            graph.get(end).add(new Node(start, dist));
        }
    }
}

class Node implements Comparable<Node>{
    int index, dist;
    
    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node n) {
        return this.dist - n.dist;
    }
};