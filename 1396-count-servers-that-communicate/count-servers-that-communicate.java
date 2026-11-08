
class Solution{
    public int countServers(int[][] grid){
        int m=grid.length,n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    boolean found=false;
                    for(int c=0;c<n;c++){
                        if(c!=j&&grid[i][c]==1)found=true;
                    }
                    for(int r=0;r<m;r++){
                        if(r!=i&&grid[r][j]==1)found=true;
                    }
                    if(found)count++;
                }
            }
        }
        return count;
    }
}
