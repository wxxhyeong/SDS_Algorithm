/*
백준 3425. 고스택
 */
package Day1_Algorithm_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int result;
        ArrayList<String> commands = new ArrayList<>();
        ArrayList<Long> temps = new ArrayList<>(); // 입력받는 x의 범위가 100억이므로
        String comm;

        while (true) {
            while (true) {
                stk = new StringTokenizer(br.readLine());
                comm = stk.nextToken();
                if (comm.equals("END")) {
                    break;
                }
                else if (comm.equals("NUM")){
                    temps.add(Long.parseLong(stk.nextToken()));
                }
                commands.add(comm);
            }

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                long[] stack = new long[2001];
                int top = 0;
                int j = 0;
                stack[0] = Long.parseLong(br.readLine());
                boolean isError = false;

                for (String command : commands) {
                    switch (command) {
                        case "NUM":
                            stack[++top] = temps.get(j++);
                            break;
                        case "POP":
                            if (top == -1) {
                                isError = true;
                                break;
                            }
                            top--;
                            break;
                        case "INV":
                            if (top == -1) {
                                isError = true;
                                break;
                            }
                            stack[top] = -(stack[top]);
                            break;
                        case "DUP":
                            if (top == -1) {
                                isError = true;
                                break;
                            }
                            stack[top + 1] = stack[top];
                            break;
                        case "SWP":
                            if (top == 0) {
                                isError = true;
                                break;
                            }
                            long tmp = stack[top];
                            stack[top] = stack[top - 1];
                            stack[top-1] = tmp;
                            break;
                        case "ADD":
                            if (top == 0) {
                                isError = true;
                                break;
                            }
                            stack[top - 1] = stack[top] + stack[top - 1];
                            top--;
                            break;
                        case "SUB":
                            if (top == 0) {
                                isError = true;
                                break;
                            }
                            stack[top - 1] = stack[top - 1] - stack[top];
                            top--;
                            break;
                        case "MUL":
                            if (top == 0) {
                                isError = true;
                                break;
                            }
                            stack[top - 1] = stack[top - 1] * stack[top];
                            top--;
                            break;
                        case "DIV":
                            if (top == 0 || stack[top] == 0) {
                                isError = true;
                                break;
                            }
                            if ((stack[top] < 0 && stack[top - 1] > 0) || (stack[top] > 0 && stack[top - 1] < 0)) {
                                stack[top-1] = -(Math.abs(stack[top - 1]) / Math.abs(stack[top]));
                            }
                            else {
                                stack[top - 1] = Math.abs(stack[top - 1]) / Math.abs(stack[top]);
                            }
                            top--;
                            break;
                        case "MOD":
                            if (top == 0 || stack[top] == 0) {
                                isError = true;
                                break;
                            }
                            if ((stack[top] < 0 && stack[top - 1] > 0) || (stack[top] > 0 && stack[top - 1] < 0)) {
                                stack[top-1] = -(Math.abs(stack[top - 1]) % Math.abs(stack[top]));
                            }
                            else {
                                stack[top - 1] = Math.abs(stack[top - 1]) % Math.abs(stack[top]);
                            }
                            top--;

                            break;
                    }
                    if (Math.abs(stack[top]) > 1e9 && top >= 0) {
                        isError =
                    }
                }
            }



        }
    }
}
