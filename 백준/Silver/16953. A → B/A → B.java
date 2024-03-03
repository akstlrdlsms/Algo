import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        bfs(a, b);
    }

    public static void bfs(long a, long b) {
        long result = -1;

        Queue<long[]> q = new LinkedList<>();
        q.offer(new long [] {a, 1});

        HashSet<Long> set = new HashSet<>();
        set.add(a);

        label:while(!q.isEmpty()) {
            long [] curr = q.poll();

            long currNum = curr[0];
            long currCount = curr[1];

            for(int i=0;i<2;i++) {
                long newNum = currNum;
                long newCount = currCount + 1;

                if(i == 0) {
                    // x2 하기
                    newNum *= 2;
                } else {
                    // 뒤에 1 붙이기
                    newNum *= 10;
                    newNum += 1;
                }

                if(set.contains(newNum)) continue;

                if(newNum == b) {
                    // 정답
                    result = newCount;
                    break label;
                } else {
                    if(newNum < b) {
                        set.add(newNum);
                        q.offer(new long [] {newNum, newCount});
                    }
                }
            }
        }

        print(result);
    }

    public static void print(long result) {
        System.out.println(result);
    }
}