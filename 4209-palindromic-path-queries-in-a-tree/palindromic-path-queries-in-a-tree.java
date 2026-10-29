import java.util.*;
class Solution{
    int n,LOG;
    int[] tin,tout,depth,parent,pref,bit,sz;
    int[][] up;
    List<Integer>[] graph;
    char[] s;
    void update(int i,int val){
        while(i<=n){
            bit[i]^=val;
            i+=i&-i;
        }
    }
    int query(int i){
        int res=0;
        while(i>0){
            res^=bit[i];
            i-=i&-i;
        }
        return res;
    }
    int getLCA(int u,int v){
        if(depth[u]<depth[v]){
            int t=u;
            u=v;
            v=t;
        }
        int diff=depth[u]-depth[v];
        for(int j=0;j<LOG;j++){
            if((diff&(1<<j))!=0)u=up[u][j];
        }
        if(u==v)return u;
        for(int j=LOG-1;j>=0;j--){
            if(up[u][j]!=up[v][j]){
                u=up[u][j];
                v=up[v][j];
            }
        }
        return parent[u];
    }
    public List<Boolean> palindromePath(int n,int[][] edges,String s,String[] queries){
        this.n=n;
        this.s=s.toCharArray();
        graph=new ArrayList[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] e:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        LOG=1;
        while((1<<LOG)<=n)LOG++;
        tin=new int[n];
        tout=new int[n];
        depth=new int[n];
        parent=new int[n];
        pref=new int[n];
        sz=new int[n];
        up=new int[n][LOG];
        bit=new int[n+1];
        Arrays.fill(parent,-1);
        int[] order=new int[n];
        int[] stack=new int[n];
        int top=0,timer=0;
        stack[top++]=0;
        parent[0]=0;
        while(top>0){
            int u=stack[--top];
            tin[u]=++timer;
            order[timer-1]=u;
            pref[u]=(u==0?0:pref[parent[u]])^(1<<(this.s[u]-'a'));
            for(int v:graph[u]){
                if(v==parent[u])continue;
                parent[v]=u;
                depth[v]=depth[u]+1;
                stack[top++]=v;
            }
        }
        for(int i=n-1;i>=0;i--){
            int u=order[i];
            sz[u]++;
            if(u!=0)sz[parent[u]]+=sz[u];
        }
        for(int u=0;u<n;u++){
            tout[u]=tin[u]+sz[u]-1;
            up[u][0]=parent[u];
        }
        for(int j=1;j<LOG;j++){
            for(int i=0;i<n;i++){
                up[i][j]=up[up[i][j-1]][j-1];
            }
        }
        List<Boolean> ans=new ArrayList<>();
        for(String q:queries){
            String[] p=q.split(" ");
            if(p[0].equals("update")){
                int u=Integer.parseInt(p[1]);
                char c=p[2].charAt(0);
                int change=(1<<(this.s[u]-'a'))^(1<<(c-'a'));
                this.s[u]=c;
                update(tin[u],change);
                if(tout[u]<n)update(tout[u]+1,change);
            }else{
                int u=Integer.parseInt(p[1]);
                int v=Integer.parseInt(p[2]);
                int lca=getLCA(u,v);
                int mask=pref[u]^query(tin[u])^pref[v]^query(tin[v])^(1<<(this.s[lca]-'a'));
                ans.add((mask&(mask-1))==0);
            }
        }
        return ans;
    }
}
