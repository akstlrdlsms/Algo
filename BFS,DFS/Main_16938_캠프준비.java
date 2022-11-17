package a1117;

import java.util.*;
import java.io.*;

public class Main_16938_캠프준비 {
	static int N, L, R, X, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 문제의 갯수
		L = Integer.parseInt(st.nextToken()); // 난이도 합의 최소값
		R = Integer.parseInt(st.nextToken()); // 난이도 합의 최대값
		X = Integer.parseInt(st.nextToken()); // 난이도최상 - 난이도최하 <= X
		
		int [] level = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) level[i] = Integer.parseInt(st.nextToken());
		
		result = 0;
		for(int i=2;i<=N;i++) comb(0,0,i,level,new boolean[N], new int [i]);
		System.out.println(result);
	}

	public static void comb(int start, int depth, int limit, int [] level, boolean [] visit, int [] num)
	{
		if(depth == limit)
		{
			// 검증 start~~~
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			
			for(int i=0;i<limit;i++)
			{
				sum += num[i];
				max = Math.max(num[i], max);
				min = Math.min(num[i], min);
			}
			
			if(sum < L || sum > R) return;
			if((max-min) < X) return;
			
			result++;
			return;
		}
		
		for(int i=start;i<N;i++)
		{
			if(visit[i]) continue;
			visit[i] = true;
			num[depth] = level[i];
			comb(i+1,depth+1, limit, level, visit, num);
			visit[i] = false;
		}
	}
}
