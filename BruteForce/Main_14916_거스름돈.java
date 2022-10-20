package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14916_거스름돈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = N/5;
		
		if(N != 1 && N != 3) 
		{
			if( (N%5)%2 != 0 ) 
			{
				result--;
				int M = (N%5)+5; 
				result += M/2;
			} 
			else 
			{
				int M = N%5;
				result += M/2;
			}
		} else {
			result = -1;
		}
		
		System.out.println(result);
	}
}
