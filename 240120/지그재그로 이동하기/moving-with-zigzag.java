/**
 * 오른쪽: 1(2^0), 4(2^2), 16(2^4), 64(2^6), 256(2^8), 1024(2^10)
 * 왼쪽: 2(2^1), 8(2^3), 32(2^5), 128(2^7), 512(2^9)
 * B가 A보다 작을 때 왼쪽을 기준으로 계산
 * B가 A보다 클 때 오른쪽을 기준으로 계산
 * 거리 이동 계산 방법: Math.abs(현재 좌표 - A) + Math.abs(이동할 좌표 - A)
 */
import java.util.*;
import java.io.*;

public class Main {

    private static int A, B;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int index = getIndex();

        int res = 0;
        int dist = 1;
        for (int i=0; i< index; i++) {
            res += dist*2;
            dist*=2;
        }

        res += Math.abs(B-A);
        System.out.println(res);
    }

    private static int getIndex() {
        int target = Math.abs(B-A);

        int index = B > A ? 0 : 1;
        int value = 1;

        while (true) {
            if (value*2 >= target) break;

            value *= 2;
            index += 2;
        }

        return index;
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }
}