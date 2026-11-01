
class Solution{
    public int uniquePaths(int[][] grid){
        int m=grid.length,n=grid[0].length;
        int mod=1000000007;
        int[][][] dp=new int[m+1][n+1][2];
        dp[0][0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int right=dp[i][j][0];
                int down=dp[i][j][1];
                if(grid[i][j]==0){
                    int total=(right+down)%mod;
                    dp[i][j+1][0]=(dp[i][j+1][0]+total)%mod;
                    dp[i+1][j][1]=(dp[i+1][j][1]+total)%mod;
                }else{
                    dp[i+1][j][1]=(dp[i+1][j][1]+right)%mod;
                    dp[i][j+1][0]=(dp[i][j+1][0]+down)%mod;
                }
            }
        }
        return (dp[m-1][n-1][0]+dp[m-1][n-1][1])%mod;
    }
}
