
import java.util.*;
class Solution{
    public int largestInteger(int[] nums,int k){
        int n=nums.length;
        int[] count=new int[51];
        for(int i=0;i<=n-k;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<i+k;j++)set.add(nums[j]);
            for(int x:set)count[x]++;
        }
        int ans=-1;
        for(int x=0;x<=50;x++){
            if(count[x]==1)ans=Math.max(ans,x);
        }
        return ans;
    }
}
