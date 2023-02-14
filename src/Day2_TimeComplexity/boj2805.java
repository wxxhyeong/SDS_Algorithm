package Day2_TimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2805 {

    static int n, res;  // 사용자 입력, 결과
    static long m;  //
    static int[] arr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        res = -1;

        arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = arr[n - 1];


        binarySearch(start, 1000000000);
        System.out.println(res);
    }

    static void binarySearch(int s, int e) {
        long sum = 0;

        if (s > e) {
            return;
        }

        int mid = (s + e) / 2;
        for (int i = 0; i < n; i++) {
            if (arr[i] > mid)
                sum += arr[i] - mid;
        }
        if (sum >= m) {
            if (mid > res)
                res = mid;
            binarySearch(mid + 1, e);
        }
        else {
            binarySearch(s, mid - 1);
        }
    }
}