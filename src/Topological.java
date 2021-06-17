import java.util.List;

public class Topological {



    void rec(List<Integer> adj[] , int v ,  boolean vis[] ) {
        if(vis[v]) {
            return;
        }

        vis[v] = true;

        for(int i=0;i<adj[v].size();i++) {
            rec(adj , adj[v].get(i) , vis);
        }

        System.out.println(v + " ");
    }

    void topoSort(int V, List<Integer> adj[])
    {
        int n = V;
        boolean[] vis = new boolean[n];


    }
}
