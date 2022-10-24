package a1024;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16173_점프왕쩰리 {
	static int [] dx = {1,0},
				  dy = {0,1};
					// 하, 우
	static boolean isArrive;
	static boolean isDead;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] board = new int [N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isArrive = false;
		// dfs(N, board, board[0][0], 0, 0);
		// System.out.println(isArrive ? "HaruHaru" : "Hing");
		boolean result = bfs(N, board, board[0][0], 0, 0);
		System.out.println(result ? "HaruHaru" : "Hing");
	}
	/**
	 * 
	 * @param N			게임구역의 크기
	 * @param board		게임판
	 * @param moveCnt	쩰리가 이동할 수 있는 횟수
	 * @param x			현재 쩰리의 i(행)의 값
	 * @param y			현재 쩰리의 j(열)의 값
	 */
	public static void dfs(int N, int [][] board, int moveCnt, int x, int y)
	{
		if(board[x][y] == 0) return;
		if(isArrive) return;
		// DFS를 사용할 때 가장 중요한 것은 빠져나갈수 있는 조건을 생각하는 것! (기저조건)
		// 쩰리가 더이상 움직일 수 없을 때
		if(board[x][y] == -1) 
		{
			// 쩰리가 끝점에 도착했다면
			isArrive = true;
			return;
		}
		// 2방탐색 for문
		for(int d=0;d<2;d++)
		{
			int nx = x + (dx[d] * moveCnt);
			int ny = y + (dy[d] * moveCnt);
			
			// 게임판 범위를 벗어나면 해당 경우의 수 continue 
			if(nx>=N || ny>=N) continue;
			
			dfs(N, board, board[nx][ny], nx, ny);
		}
	}
	
	public static boolean bfs(int N, int [][] board, int moveCnt, int x, int y)
	{
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int [] {x, y, moveCnt});
		boolean result = false;
		
		label:while(!q.isEmpty())
		{
			// 0: x , 1: y, 2: moveCnt;
			int [] curr = q.poll();
			
			for(int d=0;d<2;d++)
			{
				int nx = curr[0] + (dx[d] * curr[2]);
				int ny = curr[1] + (dy[d] * curr[2]);
				
				// 게임판 범위를 벗어나면 해당 경우의 수 continue 
				if(nx>=N || ny>=N) continue;
				
				if(nx == curr[0] && ny == curr[1]) break label;
				
				if(board[nx][ny] == -1) {
					result = true;
					break label;
				}
			
				
				q.offer(new int [] {nx, ny, board[nx][ny]});
			}
		} // end of while
		
		return result;
	}
}
