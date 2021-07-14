import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DetectCycle {
    int v;
    List<List<Integer>> adj;

    public DetectCycle(int b) {
        this.v = v;
        adj = new ArrayList<>(v);
        for(int i=0;i<v;i++) {
            adj.add(new LinkedList<>());
        }
    }


    public boolean isCyclic(int i , boolean[] recStack , boolean[] isVisited) {
        if(recStack[i]) {
            return  true;
        }
        if(isVisited[i]) {
            return false;
        }
        recStack[i]=true;
        isVisited[i]=true;

        List<Integer> adjNode = adj.get(i);
        boolean resp = false;
        for(int j=0;j<adjNode.size();j++) {
          resp = resp || isCyclic(j, recStack , isVisited);
        }
        recStack[i] = false;
        return resp;
    }


    private void add(int a,int b) {
        this.adj.get(a).add(b);
    }


    public static void main(String [] args) {


        boolean [] recStack = new boolean[10];
    }





}
