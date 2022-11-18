package a1118;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main_1010_다리놓기 {

	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		BigInteger [] facto = new BigInteger [31];
		
		facto[0] = BigInteger.valueOf(1);
		facto[1] = BigInteger.valueOf(1);
		
		for(int i=2; i<=30; i++) 
		{
			facto[i] = BigInteger.valueOf(1);
			facto[i] = facto[i-1].multiply(BigInteger.valueOf(i));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			BigInteger result = facto[N];
			result = result.divide(facto[N-M].multiply(facto[M]));
			sb.append(result+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
