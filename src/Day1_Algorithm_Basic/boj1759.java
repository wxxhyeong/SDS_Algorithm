package Day1_Algorithm_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1759 {
    static int l; // 암호의 자리 수
    static int c; // 알파벳의 종류 수
    static String[] cs; // 알파벳 종류
    static ArrayList<String> ans = new ArrayList<>(); //결과 저장 목록


    static void back(int x, String res) {
        int cnt = 0; // 모음 개수 카운트하는 변수

        // 종료 조건
        if (res.length() == l) {
            for (int i = 0; i < l; i++) {
                char temp = res.charAt(i);
             if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
                    cnt++; //모음 개수 확인
                }
            }
            // 모음이 하나 이상이고, 자음 개수(자릿수 - 모음 개수)가 2개 이상이면 결과에 추가
            if (cnt >= 1 && l - cnt >= 2) {
                ans.add(res);
            }
            return;
        }

        // 정렬된 cs 배열의 값을 하나씩 추가하는 백트랙킹
        for (int i = x; i < c; i++) {
                back(i + 1, res + cs[i]);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        l = Integer.parseInt(stk.nextToken()); // 암호의 자리 수
        c = Integer.parseInt(stk.nextToken()); // 알파벳의 종류 수

        stk = new StringTokenizer(br.readLine());
        cs = new String[c];

        for (int i = 0; i < c; i++) {
            cs[i] = stk.nextToken();
        }

        Arrays.sort(cs);

        back(0, "");

        for (String a : ans) {
            System.out.println(a);
        }

    }
}
