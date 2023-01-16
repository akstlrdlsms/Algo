function solution(maps) {
    var answer = -1;
    let n = maps.length;
    let m = maps[0].length;
    const di = [-1,1,0,0], dj = [0,0,-1,1];
    let v = new Array(n).fill(false).map(e => new Array(m).fill(false));
    v[0][0] = true;
    let q = [];
    q.push({x_idx:0, y_idx:0, count:1});
    let arrive = false;
    while(q.length!=0) {
        let curr = q.shift();
        for(let d=0;d<4;d++) {
            let ni = curr.x_idx + di[d];
            let nj = curr.y_idx + dj[d];
            let cnt = curr.count + 1;
            if(ni<0 || nj<0 || ni>n-1 || nj>m-1 || v[ni][nj] || maps[ni][nj] === 0) continue;
            if(ni===n-1 && nj===m-1) {
                answer = cnt;
                arrive = true;
                break;
            }
            q.push({x_idx:ni, y_idx:nj, count:cnt});
            v[ni][nj] = true;
        }
        if(arrive) break;
    }
    
    return answer;
}