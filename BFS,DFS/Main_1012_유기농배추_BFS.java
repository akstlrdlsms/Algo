package a1025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추_BFS {

	static int [] di = {-1,1,0,0}, dj = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int T=0;T<testCase;T++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int [][] board = new int [N][M];
			
			for(int i=0;i<K;i++)
			{
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				board[n][m] = 1;
			}
	
			for(int i=0;i<N;i++)
				System.out.println(Arrays.toString(board[i]));
			
			
			boolean [][] visit = new boolean [N][M];
			int butterflyCount = 0;
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					if(board[i][j] == 1 && !visit[i][j])
					{
						bfs(N, M, i, j, board, visit);
						butterflyCount++;
					}
				}
			}
			
			for(int i=0;i<N;i++) Arrays.toString(board[i]);
			
			// System.out.println(butterflyCount);
		}// end of testCase for
	}// end of main

	public static void bfs(int N, int M, int i, int j, int [][] board, boolean [][] visit)
	{
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int [] {i,j});
		visit[i][j] = true;
		
		while(!q.isEmpty())
		{
			int [] curr = q.poll();
			
			for(int d=0;d<4;d++)
			{
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				
				if(ni<0 || nj<0 || ni>N-1 || nj>M-1 || visit[ni][nj] || board[ni][nj] == 0) continue;
				
				visit[ni][nj] = true;
				q.offer(new int [] {ni,nj});
				
			}
			
		}
		
	}
}
