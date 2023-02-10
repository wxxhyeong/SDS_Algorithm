package Day2_TimeComplexity.Day2_Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2805_A {

    static int n,dt[];
    static long m;

    static int bs(int l,int r) {
        int mid,ans=-1;
        int i;

        while(l<=r)
        {
            mid = (l+r)/2;

            long sum = 0;
            for(i=1;i<=n;i++)
            {
                if(dt[i]>mid)
                    sum+=dt[i]-mid;
            }

            if(sum<m)r=mid-1;
            else
            {
                ans = mid;
                l = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        dt = new int[n+2];
        int i,j;

        st = new StringTokenizer(br.readLine());

        for(i=1;i<=n;i++)
        {
            dt[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bs(0,1000000000));
    }
}