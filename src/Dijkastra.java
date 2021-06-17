import java.util.*;

public class Dijkastra {

    Set<Integer> added;
    Set<Integer> toCheck;


    public void solve(int [][] adj, int n, int [] value) {
        int miniNext = 1000000;
        Integer mini = null;

        for(Integer val : toCheck) {
            if(value[val] < miniNext) {
                mini = val;
                miniNext = value[val];
            }
        }

        added.add(mini);
        toCheck.remove(mini);
        value[mini] = miniNext;

        for(int i=0;i<n;i++) {
            if(adj[mini][i]!=0) {
                if(!added.contains(i)) {
                    toCheck.add(i);
                    value[i] = Math.min(value[i], value[mini]+adj[mini][i]);
                }

            }
        }
    }

    public  void util(int [][] adj, int n) {
        int [] value = new int[n];
        for(int i=0;i<n;i++){
            value [i] = 1000000;
        }

        added.add(0);
        for(int i=0;i<n;i++) {
            if(adj[0][i]!=0) {
                if(!added.contains(i)) {
                    toCheck.add(i);
                    value[i] = adj[0][i];
                }
            }
        }

        while(added.size()!=n) {
            solve(adj, n, value);
        }

        for(int i=0;i<n;i++){
            System.out.println(value[i]);
        }
    }


    public static void main(String[] args)
    {
        int graph[][] = new int[][]
                { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        Dijkastra dijkastra =  new Dijkastra();
        dijkastra.added = new HashSet<>();
        dijkastra.toCheck = new HashSet<>();
        dijkastra.util(graph, 9);

    }
}
