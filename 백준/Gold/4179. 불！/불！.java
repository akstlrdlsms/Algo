import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * #: 벽
 * .: 지나갈 수 있는 공간
 * J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
 * F: 불이 난 공간
 */
public class Main {
    static int [] di = {-1, 1, 0, 0};
    static int [] dj = {0, 0, -1, 1};

    private static class Location {
        int x, y, count;
        boolean isHuman;

        public Location(int x, int y, int count, boolean isHuman) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isHuman = isHuman;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char [][] board = new char [N][M];

        Queue<Location> q = new LinkedList<>();
        boolean [][] hVisit = new boolean [N][M];
        boolean [][] fVisit = new boolean [N][M];
        ArrayList<Location> human = new ArrayList<>();
        ArrayList<Location> fire = new ArrayList<>();
        for(int i=0;i<N;i++) {
            board[i] = br.readLine().toCharArray();
            for(int j=0;j<M;j++) {
                if(board[i][j] == 'J') {
                    // 지훈이의 위치
                    hVisit[i][j] = true;
                    human.add(new Location(i, j, 0, true));
                    // q.offer(new Location(i, j, 0, true));
                } else if(board[i][j] == 'F') {
                    // 불의 위치
                    fVisit[i][j] = true;
                    fire.add(new Location(i, j, 0, false));
                    // q.offer(new Location(i, j, 0, false));
                } else if(board[i][j] != '.') {
                    hVisit[i][j] = true;
                    fVisit[i][j] = true;
                }
            }
        }

        for (Location location : human) q.offer(location);
        for (Location location : fire)  q.offer(location);

        bfs(N, M, board, hVisit, fVisit, q);
    }

    private static void bfs(int N, int M, char [][] board, boolean [][] hVisit, boolean [][] fVisit, Queue<Location> q) {
        int answer = -1;
        label:while(!q.isEmpty()) {
            Location curr = q.poll();
            if(curr.isHuman && board[curr.x][curr.y] != 'J') continue;

            for(int d=0;d<4;d++) {
                int nx = curr.x + di[d];
                int ny = curr.y + dj[d];

                // 범위를 벗어나면 탈출을 하는것이기 때문에
                // 먼저 사람이 탈출을 할 수 있는건지 확인해야한다.
                if(nx > N-1 || ny > M-1 || nx < 0 || ny < 0) {
                    if(curr.isHuman) {
                        // 사람이라면 한 번 이동시킨 후 탈출한다.
                        answer = curr.count + 1;
                        break label;
                    } else {
                        // 불이라면 continue 시킨다.

                        continue;
                    }
                }

                // 사람 또는 불일 때 이미 왔던 곳 or 못가는 곳이라면 PASS
                if( curr.isHuman && hVisit[nx][ny]) continue; // 사람
                if(!curr.isHuman && fVisit[nx][ny]) continue; // 불

                // 사람인지 불인지 확인하기
                if(curr.isHuman) {
                    // 사람일 때
                    if(board[nx][ny] == '.') {
                        // 나아갈 수 있는 공간이라면
                        hVisit[nx][ny] = true;
                        board[nx][ny] = 'J';
                        q.offer(new Location(nx, ny, curr.count + 1, true));
                    }
                } else {
                    // 불일 때 모든 것을 불태운다.
                    fVisit[nx][ny] = true;
                    board[nx][ny] = 'F';
                    q.offer(new Location(nx, ny, curr.count, false));
                }
            }

        } // end of while

        print(answer);
    }

    private static void print(int answer) {
        if(answer == -1)    System.out.println("IMPOSSIBLE");
        else                System.out.println(answer);
    }
}