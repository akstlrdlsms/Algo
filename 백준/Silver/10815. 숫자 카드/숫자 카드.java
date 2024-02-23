import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 카드갯수

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> cardSet = new HashSet<>();

        for(int i=0;i<N;i++) {
            cardSet.add(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // 판별 카드갯수

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++) {
            String answer = cardSet.contains(st.nextToken()) ? "1" : "0";

            sb.append(answer).append(" ");
        }

        System.out.println(sb);
    }
}