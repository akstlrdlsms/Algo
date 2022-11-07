package a1107; // Main_2747_피보나치수

import java.util.*;

public class Main_2747_피보나치수 {

	public static int findFiboNumber(int [] fibo, int N)
	{
		if(N == 0 || N == 1 || N == 2 || fibo[N] != 0) return fibo[N];
		fibo[N] = findFiboNumber(fibo, N-2) + findFiboNumber(fibo, N-1);
		return fibo[N]; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int [] fibo = new int [N+1];
		fibo[0] = 0;
		if	( N>=1 )	fibo[1] = 1;
		if	( N>=2 ) 	fibo[2] = 1;
		System.out.println(findFiboNumber(fibo, N));
	}

}
