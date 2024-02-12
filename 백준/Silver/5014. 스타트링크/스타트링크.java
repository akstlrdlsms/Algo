import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static class Building {
        int up = 0;
        int down = 0;
        int target = 0;
        int curr = 0;
        int total = 0;
        int count = 0;

        public Building(int total, int curr, int target, int up, int down, int count) {
            this.up = up;
            this.down = down;
            this.target = target;
            this.curr = curr;
            this.total = total;
            this.count = count;
        }
    }
    public static void main(String[] args) throws Exception {
        /*
        스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다. 강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.

        보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다. U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다. (만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)

        강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오. 만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.

         F, S, G, U, D
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int curr = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        if(target == curr) {
            print(0);
        } else {
            Building building = new Building(total, curr, target, up, down, 0);

            bfs(building);
        }
    }

    public static void bfs(Building building) {
        int result = -1;
        boolean [] visit = new boolean [building.total+1];


        Queue<Building> queue = new LinkedList<>();

        queue.offer(building);

        while(!queue.isEmpty()) {
            Building currBuilding = queue.poll();

            int currFloor = currBuilding.curr;

            int upStair = currFloor + currBuilding.up;
            int downStair = currFloor - currBuilding.down;

            int target = currBuilding.target;

            int count = ++currBuilding.count;

            // 방문처리
            visit[currFloor] = true;

            // 윗층 또는 아랫층이 목적지일 때
            if(upStair == target || downStair == target) {
                result = count;
                break;
            }

            // 올라갔을 때
            if(upStair <= building.total && !visit[upStair]) {
                visit[upStair] = true;
                if(currBuilding.up != 0){
                    queue.offer(new Building(currBuilding.total, upStair, target, currBuilding.up, currBuilding.down, count));
                }
            }

            // 내려갔을 때
            if(downStair >= 1 && !visit[downStair]) {
                visit[downStair] = true;
                if(currBuilding.down != 0) {
                    queue.offer(new Building(currBuilding.total, downStair, target, currBuilding.up, currBuilding.down, count));
                }
            }
        }

        print(result);
    }

    public static void print(int result) {
        if(result > -1)  System.out.println(result);
        else                System.out.println("use the stairs");
    }
}