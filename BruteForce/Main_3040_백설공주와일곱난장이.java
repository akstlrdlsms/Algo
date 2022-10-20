package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3040_백설공주와일곱난장이 
{
	static boolean isHundred;
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 9;
		
		int [] arr = new int [N];
		int sum = 0;
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		boolean isHundred = false;
		int firstFake = -1;
		int secondFake = -1;
		while(!isHundred)
		{
			for(int i=0;i<N-1;i++)
			{
				int a = arr[i];
				for(int j=i+1;j<N;j++)
				{
					int b = arr[j];
					
					if(sum - (a + b) == 100) 
					{
						isHundred = true;
						firstFake = i;
						secondFake = j;
						
						break;
					}
				}
				
				if(isHundred) break;
			}
			
		}// end of while
		
		for(int i=0;i<N;i++)
		{
			if(i == firstFake || i == secondFake) continue;
			System.out.println(arr[i]);
		}
		
	}

}
