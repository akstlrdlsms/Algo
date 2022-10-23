package a1023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 N == 5
	* 		1
   ***		2
  ***** 	3 
 *******	4 
********* 	5
 *******
  *****
   ***
    *
 */
public class Main_2444_별찍기7 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int halfPoint = N-1;
		int maxSize = N + halfPoint;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<maxSize;i++) {
			if(i==N-1)
			{
				for(int j=0;j<maxSize;j++)
					sb.append("*");
			}
			else
			{
				// 별 갯수 조정해야할 때
				int gap = Math.abs(halfPoint - i);
				int starPoint = Math.abs(maxSize - (gap*2));
				
				for(int j=0;j<gap;j++)
					sb.append(" ");
				
				for(int j=0;j<starPoint;j++)
					sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
