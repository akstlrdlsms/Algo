import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int N = park.length;
        int M = park[0].length();
        
        char [][] map = new char [N][];
        
        int [] puppy = new int [2];
        
        for(int i=0;i<N;i++)
        {
            map[i] = park[i].toCharArray();
            for(int j=0;j<M;j++)
            {
                if(map[i][j] == 'S')
                {
                    puppy[0] = i;
                    puppy[1] = j;
                }
            }
        } 
        
        int cycle = routes.length;
        
        for(int i=0;i<cycle;i++)
        {
            StringTokenizer st = new StringTokenizer(routes[i]);
            String dir = st.nextToken();
            int dis = Integer.parseInt(st.nextToken());
            
            int pi = puppy[0];
            int pj = puppy[1];
            int npi = pi;
            int npj = pj;
            
            boolean flag = true;
            
            switch(dir)
            {
                case "S":
                    npi = pi + dis;
                    if(npi < N && npj < M && npi >= 0 && npj >= 0) 
                        flag = move(pi, npi, pj, pj, map);
                    else continue;
                    break;
                case "N":
                    npi = pi - dis;
                    if(npi < N && npj < M && npi >= 0 && npj >= 0) 
                        flag = move(npi, pi, pj, pj, map);
                    else continue;
                    break;
                case "E":
                    npj = pj + dis;
                    if(npi < N && npj < M && npi >= 0 && npj >= 0) 
                        flag = move(pi, pi, pj, npj, map);
                    else continue;
                    break;
                case "W":
                    npj = pj - dis;
                    if(npi < N && npj < M && npi >= 0 && npj >= 0) 
                        flag = move(pi, pi, npj, pj, map);
                    else continue;
                    break;
            }
            // System.out.println( (i+1)+"회차 flag : "+flag);
            // System.out.println(npi + "   " + npj);
            if(!flag)
            {
                puppy[0] = npi;
                puppy[1] = npj;
            }
        }
        return puppy;
    }
    
    public boolean move(int si, int ei, int sj, int ej, char[][] map)
    {
        // map을 벗어나지 않았다면 false

        // 장애물이 있는지 확인
        for(int i=si;i<=ei;i++)
        {
            for(int j=sj;j<=ej;j++)
            {
                if(map[i][j] == 'X') return true;
            }
        }

        return false;
    }
}