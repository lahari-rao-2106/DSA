class Solution{
    public int minSumOfLengths(int[] arr,int target){
        int n=arr.length;
        int[] best=new int[n];
        int inf=1000000;
        int left=0,sum=0,shortest=inf,answer=inf;
        for(int right=0;right<n;right++){
            sum+=arr[right];
            while(sum>target){
                sum-=arr[left++];
            }
            if(sum==target){
                int len=right-left+1;
                if(left>0&&best[left-1]!=inf){
                    answer=Math.min(answer,len+best[left-1]);
                }
                shortest=Math.min(shortest,len);
            }
            best[right]=shortest;
        }
        return answer==inf?-1:answer;
    }
}