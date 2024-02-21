import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;
    private static class Location {
        int r,c,l,count;

        public Location(int r, int c, int l, int count) {
            this.r = r;
            this.c = c;
            this.l = l;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[][][] board;
        Location start;

        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());   // 층
            int R = Integer.parseInt(st.nextToken());   // 행
            int C = Integer.parseInt(st.nextToken());    // 열
            
            if(L == 0 && R == 0 && C == 0) break;

            board = new char[R][C][L];
            start = null;

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String str = br.readLine();
                    for (int c = 0; c < C; c++) {
                        board[r][c][l] = str.charAt(c);
                        if (board[r][c][l] == 'S') {
                            start = new Location(r, c, l, 0);
                        }
                    }
                }
                br.readLine();
            }

            bfs(board, start, L, R, C);
        }

        System.out.println(sb.toString());
    }

    private static void bfs(char [][][] board, Location start, int L, int R, int C) {
        int answer = -1;
        int [] dl = {-1, 1, 0, 0, 0, 0};
        int [] dr = {0, 0, -1, 1, 0, 0};
        int [] dc = {0, 0, 0, 0, -1, 1};

        Queue<Location> q = new LinkedList<>();
        q.offer(start);

        boolean [][][] visit = new boolean [R][C][L];

        // 시작지점 방문처리
        visit[start.r][start.c][start.l] = true;

        label:while(!q.isEmpty()) {
            Location curr = q.poll();

            for(int d=0;d<6;d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                int nl = curr.l + dl[d];

                // board 범위에 벗어났거나 이미 방문했던 곳 그리고 벽이라면 이라면 PASS
                if(nl > L-1 || nr > R-1 || nc > C-1 || nl < 0 || nr < 0 || nc < 0 || visit[nr][nc][nl] || board[nr][nc][nl] == '#') continue;

                // 도착지점이라면 이동횟수+1 해준 값 대입 후 while문 탈출
                if(board[nr][nc][nl] == 'E') {
                    answer = curr.count + 1;
                    break label;
                }

                // 도착지점이 아니라면
                // 방문처리
                visit[nr][nc][nl] = true;

                // 다음지점 저장
                q.offer(new Location(nr, nc, nl, curr.count + 1));
            }
        }

        print(answer);
    }

    private static void print(int answer) {
        if(answer > -1) sb.append("Escaped in ").append(answer).append(" minute(s).");
        else            sb.append("Trapped!");

        sb.append("\n");
    }
}