/*
백준 9663. n-queen
 */
package Day1_Algorithm_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9663 {

    static int cnt, n;
    static int[] visit_y;
    static int[] visit_l;
    static int[] visit_r;

    static void back(int x) {
        //System.out.println(x);
        if (x == n) {
            cnt++;
            return;
        }

        for (int y = 0; y < n; y++) {
            if (visit_y[y] == 0 && visit_r[x - y + (n + 1)] == 0 && visit_l[x + y] == 0) {
                visit_y[y] = 1;
                visit_l[x+y] = 1;
                visit_r[x - y + (n + 1)] = 1;
                back(x + 1);
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
