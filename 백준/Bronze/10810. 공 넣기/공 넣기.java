import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] basket = new int [N+1];

        for(int cycle=0;cycle<M;cycle++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 첫번째 바구니
            int m = Integer.parseInt(st.nextToken()); // 두번째 바구니
            int num = Integer.parseInt(st.nextToken()); // 공의 숫자

            for(int i=n;i<=m;i++) {
                basket[i] = num;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++) {
            sb.append(basket[i]).append(" ");
        }

        System.out.println(sb);
    }
}