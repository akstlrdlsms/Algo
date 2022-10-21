package a1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11170_0의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sNum = Integer.parseInt(st.nextToken());
			int eNum = Integer.parseInt(st.nextToken());
			
			int zeroCnt = 0;
			
			for(int i=sNum; i<=eNum; i++)
			{
				String str = Integer.toString(i);
				int strLen = str.length();
				
				for(int j=0;j<strLen;j++)
				{
					char zero = str.charAt(j);
					if(zero == '0') zeroCnt++;
				}
			}
			
			System.out.println(zeroCnt);
		}
	}

}
