package Day2_TimeComplexity.Day2_Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2003_A {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int dt[] = new int[n+2];
        int i,j;

        st = new StringTokenizer(br.readLine());

        for(i=1;i<=n;i++)
        {
            dt[i] = Integer.parseInt(st.nextToken());
        }

        int sum = dt[1];
        int ans = 0;
        i=j=1;
        while(j<=n)
        {
            if(sum==m)
            {
                ans++;
                sum-=dt[i++];
            }
            else if(sum<m)
            {
                sum+=dt[++j];
            }
            else// if(sum<m)
            {
                sum-=dt[i++];
            }
        }
        System.out.println(ans);
    }
}