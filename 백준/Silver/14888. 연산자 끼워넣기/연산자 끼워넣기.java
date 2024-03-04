import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int [] numList;
    static int [] separator;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numList = new int [N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) numList[i] = Integer.parseInt(st.nextToken());

        separator = new int [4];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) separator[i] = Integer.parseInt(st.nextToken());

        dfs(1, numList[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int numIndex, int num) {
        if(numIndex == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i=0;i<4;i++) {
            if(separator[i] == 0) continue;

            // 어떤연산자인지 모르겠지만 사용했으므로 -1
            separator[i]--;

            // 올바른 방법으로 연산하기
            switch(i) {
                case 0: // 더하기
                    num = plus(num, numList[numIndex]);
                    break;
                case 1: // 빼기
                    num = minus(num, numList[numIndex]);
                    break;
                case 2: // 곱하기
                    num = multiply(num, numList[numIndex]);
                    break;
                case 3: // 나누기
                    num = divide(num, numList[numIndex]);
                    break;
            }

            dfs(numIndex + 1, num);

            // 연산한 값 되돌리기
            switch(i) {
                case 0: // 더하기 -> 빼기
                    num = minus(num, numList[numIndex]);
                    break;
                case 1: // 빼기 -> 더하기
                    num = plus(num, numList[numIndex]);
                    break;
                case 2: // 곱하기 -> 나누기
                    num = divide(num, numList[numIndex]);
                    break;
                case 3: // 나누기 --> 곱하기
                    num = multiply(num, numList[numIndex]);
                    break;
            }

            separator[i]++;
        }
    }

    private static int plus(int first, int second) {
        return first + second;
    }
    private static int minus(int first, int second) {
        return first - second;
    }
    private static int divide(int first, int second) {
        return first / second;
    }
    private static int multiply(int first, int second) {
        return first * second;
    }


}