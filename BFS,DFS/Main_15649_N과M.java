package a1102;

import java.util.*;

public class Main_15649_N과M {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int [] num = new int [M];
		HashSet<Integer> set = new HashSet<>();
		dfs(N,M,0,num,set);
	}
	
	public static void dfs(int N, int M, int K, int [] num, HashSet<Integer> set)
	{
		if(K == M)
		{
			for(int i=0;i<M;i++)
				System.out.print(num[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(set.contains(i)) continue;
			set.add(i);
			num[K] = i;
			dfs(N,M,K+1,num,set);
			set.remove(i);
		}
	}
}
