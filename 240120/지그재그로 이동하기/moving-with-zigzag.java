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
        int res = solve();
        System.out.println(res);
    }

    private static int solve() {
        int target = Math.abs(B-A);

        boolean isTargetRight = B > A ? true : false;
        int restValue = isTargetRight ? 0 : 1;

        int res = 0, index = 0, calc = 1, dist = 1;
        while(true) {
            if (calc >= target && index%2 == restValue) break;
            res += dist*2;
            calc *= 2;
            index += 1;
            dist*=2;
        }

        res += Math.abs(B-A);
        return res;
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }
}