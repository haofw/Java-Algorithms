package interview;
import java.util.*;
public class Building {
    public static int shortestDistance(int[][] grid) {
        //boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int m = grid.length;
        int n = grid[0].length;
        int bsize = 0;
        List<int[]> free = new ArrayList<>();
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == 0){
                    free.add(new int[] {i,j});
                }
                if(grid[i][j] == 1)
                    bsize ++;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j< free.size(); j++){
            int b = 0;
            int lay = 0;
            int ret = 0;
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(free.get(j));
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i< size; i++){
                    int[] temp = queue.poll();
                    if(temp[0] < 0 || temp[0] >= m || temp[1] < 0 || temp[1] >= n || grid[temp[0]][temp[1]] == 2)
                        continue;
                    if(visited[temp[0]][temp[1]])
                        continue;
                    visited[temp[0]][temp[1]] = true;
                    if(grid[temp[0]][temp[1]] == 1){
                        b ++;
                        ret += lay;
                        continue;
                    }
                    queue.offer(new int[]{temp[0] + 1, temp[1]});
                    queue.offer(new int[]{temp[0] - 1, temp[1]});
                    queue.offer(new int[]{temp[0], temp[1] + 1});
                    queue.offer(new int[]{temp[0], temp[1] - 1});
                }
                lay ++;
            }
            if(b == bsize)
                min = Math.min(min, ret);
        }
        if(min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
    public static void main(String[] args) {
    		int[][] grid = {{1,0,0,0},{2,0,1,1}};
    		System.out.print(shortestDistance(grid));
    }
}
