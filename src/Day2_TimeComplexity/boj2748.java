package Day2_TimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2748 {

    static int n;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(arr[n]);

    }

    static long fibo(int x) {
        if (x <= 1) {
            return arr[x];
        }

        return fibo(x - 1) + fibo(x - 2);
    }

}
