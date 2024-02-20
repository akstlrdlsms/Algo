import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        int [][] board = new int [N][M];
        boolean [][] visit = new boolean [N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(!visit[i][j] && board[i][j] == 1) {
                    result++;
                    visit[i][j] = true;
                    max = Math.max(bfs(visit, board, i,j), max);
                }
            }
        }

        System.out.println(result);
        System.out.println(max);
    }

    static int bfs(boolean [][] visit, int [][] board, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int currBoardSize = 1;

        int [] di = {-1, 1, 0, 0};
        int [] dj = {0, 0, -1, 1};
        int N = board.length;
        int M = board[0].length;

        q.offer(new int [] {x,y});

        while(!q.isEmpty()) {
            int [] curr = q.poll();

            for(int d=0;d<4;d++) {
                int nx = curr[0] + di[d];
                int ny = curr[1] + dj[d];

                // 범위에 벗어나거나 이미 방문했던 곳 그리고 그림이 그려져있지 않은 곳이라면 PASS
                if(nx > N-1 || nx < 0 || ny > M-1 || ny < 0 || visit[nx][ny] || board[nx][ny] == 0) continue;

                currBoardSize++;
                visit[nx][ny] = true;

                q.offer(new int [] {nx, ny});
            }
        }

        return currBoardSize;
    }
}