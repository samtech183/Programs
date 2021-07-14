import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleInUndirectedGraph {


    Map<Integer, List<Integer>> adj = new HashMap<>();

    public boolean dfs(int node,  boolean[] vis , int[] parent) {
        if(vis[node]) {
            return true;
        }
        vis[node] = true;
        boolean resp = false;
        List<Integer> conn = adj.get(node);
        if(conn!=null) {
            for(int i=0;i<conn.size();i++) {
                if(conn.get(i)!=parent[node]) {
                    parent[conn.get(i)] = node;
                    resp = resp || dfs(conn.get(i) , vis, parent);
                }
            }
        }
        return resp;
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int n = B.size();

        for(int i=0;i<n;i++) {
            int start = B.get(i).get(0);
            int end = B.get(i).get(1);

            if(adj.containsKey(start)) {
              List<Integer> list =   adj.get(start);
              list.add(end);
              adj.put(start , list);
            }
            else {
                adj.put(start , new ArrayList<>());
                List<Integer> list =   adj.get(start);
                list.add(end);
                adj.put(start , list);
            }

            if(adj.containsKey(end)) {
                List<Integer> list =   adj.get(end);
                list.add(start);
                adj.put(end , list);
            }
            else {
                adj.put(end , new ArrayList<>());
                List<Integer> list =   adj.get(end);
                list.add(start);
                adj.put(end , list);
            }
        }

        boolean [] visited = new boolean[A+1];
        int [] parent = new int[A+1];
        for(int i=1;i<=A;i++) parent[i]=i;

        boolean ans = false;
        for(int i=1;i<=A;i++) {
            if(!visited[i]) {
             ans = ans ||  dfs(i , visited,parent);
            }
        }
        if(ans) return 1;
        return 0;
    }


    public static  void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(2);


        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(3);


        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(2);
        row3.add(3);

        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(1);
        row4.add(4);

        ArrayList<Integer> row5 = new ArrayList<>();
        row5.add(4);
        row5.add(5);


        A.add(row);
        A.add(row2);
        A.add(row3);
        A.add(row4);
        A.add(row5);

        CycleInUndirectedGraph cycleInUndirectedGraph = new CycleInUndirectedGraph();
       int ans =  cycleInUndirectedGraph.solve(5,A);
       System.out.println(ans);
    }

}
