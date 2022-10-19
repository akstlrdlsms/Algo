package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7568_덩치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] weight = new int [N];
		int [] tall = new int [N];
		
		int [] result = new int [N];
		
		Arrays.fill(result, 1);
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			weight[i] 	= Integer.parseInt(st.nextToken());
			tall[i] 	= Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) { 		// 기준대상 i
			int standardWeight 	= weight[i];
			int standardTall 	= tall[i];
			for(int j=0;j<N;j++) { 	// 비교대상 j
				if(i == j) continue;
				
				int compareWeight 	= weight[j];
				int compareTall 	= tall[j];
				
				if(standardWeight < compareWeight) {
					if(standardTall < compareTall) {
						result[i]++;
					}
				}
 			}
		}
		
		for(int i=0;i<N;i++) {
			if(i==N-1)	System.out.print(result[i]);
			else		System.out.print(result[i]+" ");
		}
			
			
		
	}

}
