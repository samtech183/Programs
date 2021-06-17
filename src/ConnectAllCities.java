import java.util.HashSet;
import java.util.Set;

public class ConnectAllCities {

    int [] parent;

    public  static class vertex {
        int start;
        int end;
        int val;
    }

    public vertex getNextMin(int [][] adj,int n, boolean [][] vis) {
        vertex ver = new vertex();
        int mini = 100000;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {

                if(adj[i][j]<mini && adj[i][j]!=0 && !vis[i][j]) {
                    mini = adj[i][j];
                    ver.start = i;
                    ver.end = j;
                    ver.val = mini;
                }
            }
        }
        return ver;
    }

    public void union(int a,int b) {
        parent[a] = b;
    }

    public int getParent(int a) {
        while(parent[a]!=a) {
            a = parent[a];
        }
        return a;
    }


    public int findMST(int [][] adj, int n) {
        parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }

       boolean [][] vis = new boolean[n][n];
       for(int i=0;i<n;i++) {
           for(int j=0;j<n;j++) {
               vis[i][j] = false;
           }
       }

       //Set<Integer> mst = new HashSet<>();

       int count=0;
       int ans = 0;
       while(count<n-1){
           vertex vertex = getNextMin(adj,n,vis);
           vis[vertex.start][vertex.end] = true;
           int p1 = getParent(vertex.start);
           int p2 = getParent(vertex.end);
           if(p1==p2) {
               continue;
           }
           union(p1 ,p2);
           count++;
           ans += vertex.val;
       }

       return  ans;
    }

    public static void main(String args[])
    {

        ConnectAllCities allCities = new ConnectAllCities();
        // Input 1
        int n1 = 6;
        int city1[][] = {
                { 0, 1, 1, 100, 0, 0 },
                { 1, 0, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0 },
                { 100, 0, 0, 0, 2, 2 },
                { 0, 0, 0, 2, 0, 2 },
                { 0, 0, 0, 2, 2, 0 } };

        allCities.findMST(city1, n1);

    }
}
