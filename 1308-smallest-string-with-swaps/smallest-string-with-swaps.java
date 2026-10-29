
import java.util.*;
class Solution{
    public String smallestStringWithSwaps(String s,List<List<Integer>> pairs){
        int n=s.length();
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(List<Integer> p:pairs){
            int a=p.get(0),b=p.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }
        char[] arr=s.toCharArray();
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i])continue;
            List<Integer> indices=new ArrayList<>();
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            vis[i]=true;
            while(!q.isEmpty()){
                int u=q.poll();
                indices.add(u);
                for(int v:graph[u]){
                    if(!vis[v]){
                        vis[v]=true;
                        q.add(v);
                    }
                }
            }
            List<Character> chars=new ArrayList<>();
            for(int idx:indices)chars.add(arr[idx]);
            Collections.sort(indices);
            Collections.sort(chars);
            for(int j=0;j<indices.size();j++)arr[indices.get(j)]=chars.get(j);
        }
        return new String(arr);
    }
}
