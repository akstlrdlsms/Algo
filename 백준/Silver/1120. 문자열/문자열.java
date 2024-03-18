import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        String str2 = st.nextToken();

        String target = str1.length() >= str2.length() ? str1 : str2;
        String object = str1.length() >= str2.length() ? str2 : str1;

        int targetSize = target.length();
        int objectSize = object.length();

        int term = targetSize - objectSize;

        int min = Integer.MAX_VALUE;

        for(int i=0;i<=term;i++) {
            int currCount = 0;
            String targetString = target.substring(i, objectSize+i);
            for(int idx=0;idx<objectSize;idx++) {
                if(targetString.charAt(idx) != object.charAt(idx)) currCount++;
            }
            min = Math.min(currCount, min);
        }

        System.out.println(min);
    }
}