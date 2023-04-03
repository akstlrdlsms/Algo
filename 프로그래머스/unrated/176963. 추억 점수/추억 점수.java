import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int answerCnt = photo.length;
        int[] answer = new int [answerCnt];
        
        int len = name.length;
        HashMap<String, Integer> photoMap = new HashMap<>();
        
        for(int i=0;i<len;i++)
            photoMap.put(name[i], yearning[i]);
        
        for(int i=0;i<answerCnt;i++)
        {
            int photoLen = photo[i].length;
            int yearningSum = 0;
            for(int j=0;j<photoLen;j++)
            {
                String photoName = photo[i][j];
                if(photoMap.containsKey(photoName))
                    yearningSum += photoMap.get(photoName);
            }
            
            answer[i] = yearningSum;
        }
        
        return answer;
    }
}