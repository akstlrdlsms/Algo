package a1118;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static int N, M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		String [] word = new String [N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			word[i] = st.nextToken();
		}
		
		Arrays.sort(word);
		
		boolean [] visit = new boolean [N];
		String [] result = new String [M];
		sb = new StringBuilder();
		
		comb(0,0,visit,word,result);
		System.out.println(sb.toString());
	}
	
	public static void comb(int start, int depth, boolean [] visit, String [] word, String [] result) {
		if(depth == M)
		{
			if(validateResult(result)) 
			{
				for(int i=0;i<M;i++) 
				{
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=start;i<N;i++)
		{
			if(visit[i]) continue;
			visit[i] = true;
			result[depth] = word[i];
			comb(i+1, depth+1, visit, word, result);
			visit[i] = false;
		}
	}
	
	public static boolean validateResult(String [] result)
	{
		int jaum = 0;
		int moum = 0;
		
		for(int i=0;i<M;i++)
		{
			String currWord = result[i];
			if( ("a".equals(currWord) || "e".equals(currWord) ||"i".equals(currWord) ||
			     "o".equals(currWord) || "u".equals(currWord) ))
				moum++;
			else
				jaum++;
		}
		
		if(jaum >= 2 && moum >= 1) 	return true;
		else						return false;
	}
}
