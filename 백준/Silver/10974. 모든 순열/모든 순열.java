import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [N];
        boolean [] visit = new boolean [N+1];
        StringBuilder sb = new StringBuilder();
        perm(N, 0, arr, visit, sb);
        System.out.println(sb);
    }

    public static void perm(int N, int depth, int[] arr, boolean [] visit, StringBuilder sb)
    {
        if(depth == N)
        {
            print(N, arr, sb);
        }

        for(int i=1;i<=N;i++)
        {
            if(!visit[i])
            {
                visit[i] = true;
                arr[depth] = i;
                perm(N, depth+1, arr, visit, sb);
                visit[i] = false;
            }
        }
    }

    public static void print(int N, int [] arr, StringBuilder sb)
    {
        for(int i=0;i<N;i++)
        {
            sb.append(arr[i]+" ");
        }
        sb.append("\n");
    }
}