package a1102;

import java.util.*;
import java.io.*;

public class Main_2206_벽부수고이동하기 {
	static int N,M;
	static char[][] map;
	
	public static class Person {
		int x;
		int y;
		int count;
		boolean isBroken;
		
		public Person(int x, int y, int count, boolean isBroken) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.isBroken = isBroken;
		}
	}
	
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char [N][M];
		
		for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
		
		System.out.println(bfs());
	}

	public static int bfs() 
	{
		int answer = -1;
		Queue<Person> q = new LinkedList<>();
		
		if(0 == N-1 && 0 == M-1) return 1;
		
		int [] di = {-1,1,0,0}, dj = {0,0,-1,1};
		
		q.offer(new Person(0,0,1,false));
		
		boolean [][] v_doBroken = new boolean [N][M];
		boolean [][] v_noBroken = new boolean [N][M];
		
		v_doBroken[0][0] = true;
		v_noBroken[0][0] = true;
		
		label:while(!q.isEmpty()) 
		{
			Person curr = q.poll();
			for(int d=0;d<di.length;d++) 
			{
				int ni = curr.x + di[d];
				int nj = curr.y + dj[d];
				int cnt = curr.count;
				boolean destroy = curr.isBroken;
				
				if(ni<0 || nj<0 || ni>=N || nj>=M) continue;
				
				if(map[ni][nj] == '0') {
					if(ni == N-1 && nj == M-1) 
					{
						answer = cnt+1;
						break label;
					}
					
					if(!destroy && !v_noBroken[ni][nj]) 
					{
						v_noBroken[ni][nj] = true;
						q.offer(new Person(ni,nj,cnt+1,destroy));
					} 
					else if(destroy && !v_doBroken[ni][nj]) 
					{
						v_doBroken[ni][nj] = true;
						q.offer(new Person(ni,nj,cnt+1,destroy));
					}
				} 
				else if(map[ni][nj] == '1' && !v_doBroken[ni][nj]) 
				{
					if(destroy) continue;
					if(ni == N-1 && nj == M-1) 
					{
						answer = cnt+1;
						break label;
					}
					v_doBroken[ni][nj] = true;
					q.offer(new Person(ni,nj,cnt+1,true));
				}
			}
		}
		for(int i=0;i<N;i++) System.out.println(Arrays.toString(v_noBroken[i]));
		System.out.println("==================================================");
		for(int i=0;i<N;i++) System.out.println(Arrays.toString(v_doBroken[i]));
		
		return answer;
	}
}
