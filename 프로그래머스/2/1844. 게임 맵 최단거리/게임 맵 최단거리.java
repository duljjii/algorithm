import java.util.*;

class Solution {
    
    public static class Player{
        int row;
        int column;
        int depth;
        
        public Player(){}
        
        public Player(int row, int column, int depth){
            this.row = row;
            this.column = column;
            this.depth = depth;
        }
    }
    
     int[] dr = {-1, 1, 0, 0};
     int[] dc = {0, 0, -1, 1};
     int endRow = 0;
     int endColumn = 0;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        // 맵 크기 구하기
        
        endRow = maps.length;
        endColumn = maps[0].length;
        
        Queue<Player> q = new LinkedList<>();
        
        Player startPlayer = new Player();
        
        startPlayer.row = 0;
        startPlayer.column = 0;
        startPlayer.depth = 0;
        
        q.add(startPlayer);
         
        answer = bfs(q, maps);
        
        return answer;
    }
    
    public int bfs(Queue<Player> q, int[][] maps){
        
        boolean[][] visited = new boolean[endRow][endColumn];
        
        visited[0][0] = true;
        
        while(true){
            if(q.isEmpty()){
                return -1;
            }
            Player player = q.poll();
        if(player.row == endRow-1 && player.column == endColumn-1){
            return player.depth+1;
        }
        for(int d = 0; d<4; d++){
            int nr = player.row + dr[d];
            int nc = player.column + dc[d];
            if(isValid(nr, nc) && maps[nr][nc] == 1 && !visited[nr][nc]){
                q.add(new Player(nr, nc, player.depth+1));
                visited[nr][nc] = true;
            }
        }
        }
        
        
    }
    
    public boolean isValid(int r, int c){
        return 0 <= r && r < endRow && 0 <= c && c < endColumn;
    }
}