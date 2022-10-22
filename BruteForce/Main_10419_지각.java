package a1022;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10419_지각 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=0;t<testCase;t++)
		{
			int eduTime = Integer.parseInt(br.readLine());
			boolean impossible = false;
			int maxLateTime = 0;
			int lateTime = 1;
			
			while(!impossible)
			{
				int ifLateTime = lateTime * lateTime;
				
				if( (lateTime + ifLateTime) > eduTime)
				{
					impossible = true;
				}
				else 
				{
					maxLateTime++;
					lateTime++;
				}
			}
			
			System.out.println(maxLateTime);
		}
	}

}
