package a1103;

import java.util.*;
import java.io.*;

public class Main_1245_농장관리_BFS {
//  8방 탐색 순서
	//  1  8  7
	//  2     6
	//  3  4  5
	static int [] di = {-1,0,1,1,1,0,-1,-1}, // 
				  dj = {-1,-1,-1,0,1,1,1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] map = new int [N][M];
		
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int bonguriCnt = 0;
		boolean [][] bonguriVisit = new boolean [N][M];
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				bonguriCnt += findBongURi(i,j,N,M,map,bonguriVisit);
			}
		}
		
		// for(int i=0;i<N;i++) System.out.println(Arrays.toString(bonguriVisit[i]));
		System.out.println(bonguriCnt);
	} // end of main
	
	public static int findBongURi(int n, int m, int N, int M, int [][] map, boolean [][] bonguriVisit)
	{
		if(bonguriVisit[n][m]) return 0;
		boolean [][] visit = new boolean [N][M];
		
		visit[n][m] = true;
		bonguriVisit[n][m] = true;
		
		int currBongURiHeight = map[n][m];
		
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> tempBongURiList = new ArrayList<>();
		
		tempBongURiList.add(new int [] {n,m});
		q.offer(new int [] {n,m});
		
		while(!q.isEmpty())
		{
			int [] curr = q.poll();
			
			for(int d=0;d<8;d++)
			{
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				
				if(ni<0 || nj<0 || ni>N-1 || nj>M-1 || visit[ni][nj]) continue;
				
				visit[ni][nj] = true;
				
				// 같은 산봉우리일 때
				if(map[ni][nj] == currBongURiHeight)
				{
					bonguriVisit[ni][nj] = true;
					tempBongURiList.add(new int [] {ni,nj});
					q.offer(new int [] {ni,nj});
				}
				// 현재 산봉우리로 가정한 곳보다 더 높은곳이 있을 때
				else if (map[ni][nj] > currBongURiHeight)
				{
					for(int i=0;i<tempBongURiList.size();i++)
					{
						int [] temp = tempBongURiList.get(i);
						int ri = temp[0];
						int rj = temp[1];
						bonguriVisit[ri][rj] = false;
					}

					return 0;
				}
				
			}
			
		}
		// System.out.println(n+" "+m);
		return 1;
	}

}
