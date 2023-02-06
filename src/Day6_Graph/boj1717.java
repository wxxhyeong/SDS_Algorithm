package Day6_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1717 {

    static int[] graph;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        graph = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = i;
        }
        int [][] array = new int[m][3];

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(stk.nextToken());
            int q = Integer.parseInt(stk.nextToken());
            int r = Integer.parseInt(stk.nextToken());

            if (p == 0) {
                union(q, r);
            } else {
                int rootA = find(q);
                int rootB = find(r);

                if (rootA == rootB) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        graph[rootA] = rootB;

            }

    static int find(int a) {
        if (graph[a] == a) {
            return a;
        } else {
            // 루트의 값을 찾는 것을 수차례에 걸쳐서 찾지 않도록
            // 루트 노드의 값을 바꿔줘서 한번에 찾을 수 있게 해준다.
            return graph[a] = find(graph[a]);
        }
    }
}
