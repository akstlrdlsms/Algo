package a1025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1012_유기농배추_DFS {

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
			
			boolean [][] visit = new boolean [N][M];
			int butterflyCount = 0;
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					if(board[i][j] == 1 && !visit[i][j])
					{
						visit[i][j] = true;
						dfs(N, M, i, j, board, visit);
						butterflyCount++;
					}
				}
			}
			System.out.println(butterflyCount);
		}// end of testCase for
	}// end of main

	public static void dfs(int N, int M, int i, int j, int [][] board, boolean [][] visit)
	{
		for(int d=0;d<4;d++)
		{
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni<0 || nj<0 || ni>N-1 || nj>M-1 || visit[ni][nj] || board[ni][nj] == 0) continue;
			
			visit[ni][nj] = true;
			
			dfs(N, M, ni, nj, board, visit);
		}
	}
}
