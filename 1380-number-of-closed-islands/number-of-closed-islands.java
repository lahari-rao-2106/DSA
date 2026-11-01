
import java.util.*;
class Solution{
    public int closedIsland(int[][] grid){
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            bfs(grid,i,0);
            bfs(grid,i,n-1);
        }
        for(int j=0;j<n;j++){
            bfs(grid,0,j);
            bfs(grid,m-1,j);
        }
        int count=0;
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==0){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
    void bfs(int[][] grid,int r,int c){
        int m=grid.length,n=grid[0].length;
        if(r<0||c<0||r>=m||c>=n||grid[r][c]==1)return;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c]=1;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] d:dirs){
                int nr=cur[0]+d[0],nc=cur[1]+d[1];
                if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]==0){
                    grid[nr][nc]=1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
