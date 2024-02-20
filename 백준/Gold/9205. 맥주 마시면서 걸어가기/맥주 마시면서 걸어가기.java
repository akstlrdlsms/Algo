import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Location home;
    static Location festival;
    static ArrayList<Location> cuList;
    static StringBuilder sb;

    private static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        // 모든 좌표는 -32768 <= x, y <= 32767 의 범위를 가지고 있기 때문에
        // 모든 좌표값에 +32768을 더해준다.

        for(int tc=0;tc<testCase;tc++) {
            int cuCount = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            home = new Location(Integer.parseInt(st.nextToken()) + 32768, Integer.parseInt(st.nextToken()) + 32768);

            cuList = new ArrayList<>();

            for(int c=0;c<cuCount;c++) {
                st = new StringTokenizer(br.readLine());

                cuList.add(new Location(Integer.parseInt(st.nextToken()) + 32768, Integer.parseInt(st.nextToken()) + 32768));
            }

            st = new StringTokenizer(br.readLine());

            festival = new Location(Integer.parseInt(st.nextToken()) + 32768, Integer.parseInt(st.nextToken()) + 32768);

            bfs(cuCount);
        }

        System.out.println(sb.toString());
    }

    static void bfs(int cuCount) {
        boolean result = false;

        Queue<Location> q = new LinkedList<>();

        boolean [] cuVisit = new boolean [cuCount];

        q.offer(home);

        while(!q.isEmpty()) {
            Location curr = q.poll();
            int currX = curr.x;
            int currY = curr.y;

            if(Math.abs(currX- festival.x) + Math.abs(currY - festival.y) <= 1000) {
                // 페스티발 장소 거리가 1000m 이하라면
                result = true;
            }

            for(int c=0;c<cuCount;c++) {
                Location cu = cuList.get(c);
                int cuX = cu.x;
                int cuY = cu.y;

                if(!cuVisit[c] && Math.abs(currX-cuX) + Math.abs(currY-cuY) <= 1000) {
                    // 편의점의 거리가 1000m 이하라면
                    cuVisit[c] = true;
                    q.offer(new Location(cuX, cuY));
                }

            }
        }

        print(result);
    }

    static void print(boolean result) {
        if(result)  sb.append("happy").append("\n");
        else          sb.append("sad").append("\n");
    }
}