package a1024;

import java.util.*;
import java.io.*;

public class Main_2178_미로탐색 {
	static int[] di = { 1, 0, -1, 0 }; // 하 우 상 좌
	static int[] dj = { 0, 1, 0, -1 }; // 하 우 상 좌
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> q = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int[][] map = new int[N][M];
		boolean [][] visit = new boolean[N][M];
		
		for (int i = 0; i < map.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = s.charAt(j)-48;
			}
		}
		
		q.offer(new int[] { 0, 0 }); // 0 : 행 , 1 : 열
		int[] a = new int [2];
		int size = q.size();
		int result = 1;
		while (true) {
			cnt++;
			a = q.poll();
			if(a[0]==N-1 && a[1]==M-1) 
				break;
			map[a[0]][a[1]] = 0;
			visit[a[0]][a[1]] = true; // 방문했으면 true
			for(int d=0;d<di.length;d++) {
				int ni = a[0]+di[d];
				int nj = a[1]+dj[d];
				if(ni>=0 && ni < N && nj>=0 && nj<M && map[ni][nj]==1 && visit[ni][nj]==false) {
					visit[ni][nj] = true;
					map[ni][nj] = 0;
					q.offer(new int[] {ni,nj});
				}
			}
			if(cnt == size) {
				result++;
				cnt=0;
				size = q.size();
			}
		}//while
		System.out.println(result);
		
	}//main

}
