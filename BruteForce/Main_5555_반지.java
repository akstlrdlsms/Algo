package a1022;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5555_반지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String findStr = br.readLine();
		int findSize = findStr.length();
		int testCase = Integer.parseInt(br.readLine());
		int findCnt = 0;
		
		for(int t=0;t<testCase;t++)
		{
			String inputStr = br.readLine();
			int inputSize = inputStr.length();
			for(int i=0;i<inputSize;i++) 
			{
				// i는 substring의 기준 index
				int startIdx = i;
				int endIdx = i+findSize;
				String isFindStr = "";
				if(endIdx <= inputSize-1)
				{
					// substring endIdx가 문자열 최대 범위를 벗어났을 때
					isFindStr = inputStr.substring(startIdx, endIdx);
				}
				else
				{
					// substring endIdx가 문자열 최대 범위를 벗어나지 않았을 때
					isFindStr = inputStr.substring(i, inputSize);
					isFindStr += inputStr.substring(0, endIdx - inputSize);
				}
				
				// 검증
				if(isFindStr.equals(findStr))
				{
					// 조건에 부합하는 문자열이 존재하면 카운팅 후 반복문 탈출
					findCnt++;
					break;
				}
			}
		}
		
		System.out.println(findCnt);
	}

}
