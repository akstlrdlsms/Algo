import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String totalStr = br.readLine();
        String targetStr = br.readLine();

        int totalStrLen = totalStr.length();
        int targetStrLen = targetStr.length();
        boolean [] isSearchSpelling = new boolean [totalStrLen];

        int searchLen = totalStrLen - targetStrLen;
        int result = 0;
        for(int i=0;i<=searchLen;i++) {
            String searchStr = totalStr.substring(i, i + targetStrLen);

            if(isSearchSpelling[i]) continue;

            if(targetStr.equals(searchStr)) {
                searchCheck(isSearchSpelling, i, i+targetStrLen);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void searchCheck(boolean [] isSearchSpelling, int start, int end) {
        for(int i=start;i<end;i++) {
            isSearchSpelling[i] = true;
        }
    }
}