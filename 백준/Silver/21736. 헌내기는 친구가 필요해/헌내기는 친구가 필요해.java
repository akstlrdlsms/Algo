import java.io.*;
import java.util.*;


public class Main {
    static int [] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
    static int meetPersonCount;
    static boolean [][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char [][] board = new char [N][M];

        int [] curr = new int [2];

        visit = new boolean [N][M];
        meetPersonCount = 0;

        for(int i=0;i<N;i++) {
            board[i] = br.readLine().toCharArray();
            for(int j=0;j<M;j++) {
                if(board[i][j] == 'I') {
                    curr[0] = i;
                    curr[1] = j;

                    visit[i][j] = true;
                }
            }
        }

        dfs(curr[0], curr[1], N, M, board);

        System.out.println(meetPersonCount > 0 ? meetPersonCount : "TT");
    }

    private static void dfs(int i, int j, int N, int M, char[][] board) {
        for(int d=0;d<4;d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            // 사방탐색 범위 or 방문유무 or 벽 확인
            if(ni < 0 || nj < 0 || ni > N-1 || nj > M-1 || visit[ni][nj] || board[ni][nj] == 'X') continue;

            if(board[ni][nj] == 'P') meetPersonCount++;

            visit[ni][nj] = true;

            dfs(ni, nj, N, M, board);
        }
    }


}