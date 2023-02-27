import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // target
        int te = Integer.parseInt(st.nextToken());
        int ts = Integer.parseInt(st.nextToken());
        int tm = Integer.parseInt(st.nextToken());

        // limit
        int le = 15, ls = 28, lm = 19;

        // initialize
        int e = 1, s = 1, m = 1;

        // answer inistailize
        int year = 1;

        // logic start
        while(true)
        {
            // exit condition
            if(e==te && s==ts && m==tm) break;

            e++; s++; m++;

            if(e > le) e = 1;
            if(s > ls) s = 1;
            if(m > lm) m = 1;

            year++;
        }

        System.out.println(year);
    }
}