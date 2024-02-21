import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char [][] room = new char [N][];
        boolean [][] visit = new boolean [N][N];
        int garo = 0, sero = 0;
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            room[i] = new char [str.length()];
            room[i] = str.toCharArray();
        }

        // 가로

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(room[i][j] == '.' && !visit[i][j]) {
                    if(bfs(room, visit, N, i, j, true)) {
                        garo++;
                    }
                }
            }
        }

        visit = new boolean [N][N];
        // 세로
        for(int j=0;j<N;j++) {
            for(int i=0;i<N;i++) {
                if(room[i][j] == '.' && !visit[i][j]) {
                    if(bfs(room, visit, N, j, i, false)) {
                        sero++;
                    }
                }
            }
        }

        System.out.println(garo+" "+sero);
    }

    private static boolean bfs(char [][] room, boolean [][] visit, int N, int stopIndex, int moveIndex, boolean isGaro) {
        boolean result = false;

        int roomSize = 1;

        Queue<Integer> q = new LinkedList<>();
        if(isGaro)  visit[stopIndex][moveIndex] = true;
        else        visit[moveIndex][stopIndex] = true;
        q.offer(moveIndex);

        while(!q.isEmpty()) {
            int currIndex = q.poll();

            int nextIndex = currIndex + 1;

            if(nextIndex > N-1) continue;

            char roomSharp = isGaro ? room[stopIndex][nextIndex] : room[nextIndex][stopIndex];

            if(roomSharp == '.') {
                roomSize++;

                if(isGaro)  visit[stopIndex][nextIndex] = true;
                else        visit[nextIndex][stopIndex] = true;

                q.offer(nextIndex);
            }

            if(roomSize >= 2) {
                if(result) continue;
                result = true;
            }
        }

        return result;
    }
}