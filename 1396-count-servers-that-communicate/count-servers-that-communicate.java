
class Solution{
    public int countServers(int[][] grid){
        int m=grid.length,n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    int servers=dfs(grid,visited,i,j);
                    if(servers>1)count+=servers;
                }
            }
        }
        return count;
    }
    int dfs(int[][] grid,boolean[][] visited,int r,int c){
        int m=grid.length,n=grid[0].length;
        visited[r][c]=true;
        int count=1;
        for(int j=0;j<n;j++){
            if(grid[r][j]==1&&!visited[r][j]){
                count+=dfs(grid,visited,r,j);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[i][c]==1&&!visited[i][c]){
                count+=dfs(grid,visited,i,c);
            }
        }
        return count;
    }
}
