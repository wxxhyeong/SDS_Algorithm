package Day1_Algorithm_Basic.Day1_Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj3425_A {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            List<String> cmd = new ArrayList<>();
            List<Long> param = new ArrayList<>();
            while(true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String _cmd = st.nextToken();
                if(_cmd.equals("END"))
                    break;
                if(_cmd.equals("QUIT"))
                    return;

                cmd.add(_cmd);
                if(_cmd.equals("NUM"))
                {
                    long _param = Long.parseLong(st.nextToken());
                    param.add(_param);
                }
            }

            int n = Integer.parseInt(br.readLine());

            for(int i=1;i<=n;i++)
            {
                long[] stack = new long[2001];
                int top = 0;
                int j = 0;
                stack[0] = Long.parseLong(br.readLine());
                boolean isError = false;

                for(String _cmd : cmd)
                {
                    switch(_cmd) {
                        case "NUM":
                            stack[++top] = param.get(j++);
                            break;
                        case "POP":
                            if(top==-1) {
                                isError = true;
                                break;
                            }
                            top--;
                            break;
                        case "INV":
                            if(top==-1) {
                                isError = true;
                                break;
                            }
                            stack[top] = -stack[top];
                            break;
                        case "DUP":
                            if(top==-1) {
                                isError = true;
                                break;
                            }
                            stack[top+1] = stack[top];
                            top++;
                            break;
                        case "SWP":
                            if(top==0) {
                                isError = true;
                                break;
                            }
                            long tmp = stack[top];
                            stack[top]=stack[top-1];
                            stack[top-1] = tmp;
                            break;
                        case "ADD":
                            if(top==0) {
                                isError = true;
                                break;
                            }
                            stack[top-1] += stack[top];
                            top--;
                            break;
                        case "SUB":
                            if(top==0) {
                                isError = true;
                                break;
                            }
                            stack[top-1] -= stack[top];
                            top--;
                            break;
                        case "MUL":
                            if(top==0) {
                                isError = true;
                                break;
                            }
                            stack[top-1] *= stack[top];
                            top--;
                            break;
                        case "DIV":
                            if(top==0 || stack[top] == 0) {
                                isError = true;
                                break;
                            }
                            if((stack[top]<0)^(stack[top-1]<0))
                                stack[top-1] = -(Math.abs(stack[top-1])/Math.abs(stack[top]));
                            else
                                stack[top-1] = (Math.abs(stack[top-1])/Math.abs(stack[top]));
                            top--;
                            break;
                        case "MOD":
                            if(top==0 || stack[top] == 0) {
                                isError = true;
                                break;
                            }
                            if(stack[top-1]<0)
                                stack[top-1] = -(Math.abs(stack[top-1])%Math.abs(stack[top]));
                            else
                                stack[top-1] = (Math.abs(stack[top-1])%Math.abs(stack[top]));
                            top--;
                            break;
                    }

                    if(top >=0 && Math.abs(stack[top]) > 1e9)
                    {
                        isError = true;
                        break;
                    }
                }

                if(isError || top != 0)
                    System.out.println("ERROR");
                else
                    System.out.println(stack[top]);
            }

            String a = br.readLine();
            System.out.println();
        }
    }

}