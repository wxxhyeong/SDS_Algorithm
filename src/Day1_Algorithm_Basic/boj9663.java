/*
백준 9663. n-queen
 */
package Day1_Algorithm_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9663 {

    static int cnt, n;
    static int[] visit_y;  // 열의 퀸 유무 체크 배열
    static int[] visit_l;  // 왼쪽 방향으로 내려가는 대각선 퀸 유무 체크 배열
    static int[] visit_r;  // 오른쪽 방향으로 내려가는 대각선 퀸 유무 체크 배열

    static void back(int x) {
        // 행 x의 값이 n인 경우, 즉 체스판 가장 아래까지 퀸이 배치된 경우 경우의 수를 증가시키고 종료
        if (x == n) {
            cnt++;
            return;
        }

        // x번째 행의 y번째 열을 탐색
        for (int y = 0; y < n; y++) {
            // 순서대로 열, 대각선 오, 왼 방향의 퀸 유무 확인
            if (visit_y[y] == 0 && visit_r[x - y + (n + 1)] == 0 && visit_l[x + y] == 0) {
                visit_y[y] = 1;
                visit_l[x+y] = 1;
                visit_r[x - y + (n + 1)] = 1;
                back(x + 1); // 퀸 유무 확인 후, 다음 행 탐색
                visit_y[y] = 0;
                visit_l[x+y] = 0;
                visit_r[x - y + (n + 1)] = 0;

            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit_y = new int[n];
        visit_l = new int[2 * n + 1];
        visit_r = new int[2 * n + 1];

        back(0);
        System.out.println(cnt);

    }
}
