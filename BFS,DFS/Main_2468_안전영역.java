package a1104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	static int [] di = {-1,1,0,0},
			      dj = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] map = new int [N][N];
		
		StringTokenizer st;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] < min) min = map[i][j];
				if(map[i][j] > max) max = map[i][j];
			}
		}
		
		int result = 0;
		
		for(int rain=min-1;rain<max;rain++)
		{
			boolean [][] chimsu = new boolean [N][N];
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(map[i][j] <= rain) chimsu[i][j] = true;
				}
			}
			
			boolean [][] visit = new boolean [N][N];
			int currValue = 0;
			for(int i=0;i<N;i++) 
			{
				for(int j=0;j<N;j++)
				{
					if(!chimsu[i][j] && !visit[i][j])
					{
						currValue += bfs(i,j,N,chimsu,visit);
					}
				}
			}
			
			result = Math.max(result, currValue);
		}
		
		System.out.println(result);
	} // end of main
	
	public static int bfs(int i, int j, int N, boolean [][] chimsu, boolean [][] visit)
	{
		visit[i][j] = true;
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int [] {i,j});
		
		while(!q.isEmpty())
		{
			int [] curr = q.poll();
			
			for(int d=0;d<4;d++)
			{
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				
				if(ni<0 || nj<0 || ni>N-1 || nj>N-1 || visit[ni][nj] || chimsu[ni][nj]) continue;
				
				visit[ni][nj] = true;
				q.offer(new int [] {ni,nj});
			}
		}
		return 1;
	}

}
