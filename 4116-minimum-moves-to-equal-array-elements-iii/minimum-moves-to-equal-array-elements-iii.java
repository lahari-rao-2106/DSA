class Solution{
    public int minMoves(int[] nums){
        int max=nums[0];
        int moves=0;
        for(int x:nums)if(x>max)max=x;
        for(int x:nums)moves+=max-x;
        return moves;
    }
}
