import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> [] list;
    static boolean [] visit;
    static int [] parent;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        list = new ArrayList [N+1];
        visit = new boolean [N+1];
        parent = new int [N+1];

        for(int i=1;i<N+1;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list[first].add(second);
            list[second].add(first);
        }
        parent[1] = 1;

        dfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<N+1;i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int num) {
        visit[num] = true;

        for(int n : list[num]) {
            if(visit[n]) continue;
            parent[n] = num;
            dfs(n);
        }
    }
}