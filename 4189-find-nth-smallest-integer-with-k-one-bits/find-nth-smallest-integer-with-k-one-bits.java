class Solution{
    public long nthSmallest(long n,int k){
        long[][] dp=new long[51][51];
        for(int i=0;i<=50;i++){
            dp[i][0]=1;
            for(int j=1;j<=i;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
        long ans=0;
        for(int i=49;i>=0;i--){
            long count=(k<=i)?dp[i][k]:0;
            if(n>count){
                n-=count;
                ans|=(1L<<i);
                k--;
            }
            if(k==0)break;
        }
        return ans;
    }
}