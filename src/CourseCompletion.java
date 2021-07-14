import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseCompletion {

    boolean checkIfCycliC(Map<Integer , List<Integer>> adj,int curr,  boolean[] rec) {
        if(rec[curr]) {
            return true;
        }
        rec[curr]=true;

        Boolean resp = false;
        List<Integer> adJs =  adj.get(curr);

        if(adJs==null) return false;

        for(Integer val : adJs) {
           resp = resp ||  checkIfCycliC(adj,val,rec);

        }
        rec[curr] = false;
        return resp;
    }

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Map<Integer , List<Integer>> adj = new HashMap<>();
        int n = B.size();
        for(int i=0;i<n;i++) {
           if(adj.containsKey(C.get(i))) {
               adj.get(C.get(i)).add(B.get(i));
           }
           else {
               adj.put(C.get(i) , new ArrayList<>());
               adj.get(C.get(i)).add(B.get(i));
           }
        }
        boolean[] recStack = new boolean[A+1];

        for(int i=1;i<=A;i++) {
            recStack[i] = false;
        }

        for(int i=1;i<A;i++) {
            for(int j=1;j<=A;j++) {
                recStack[j] = false;
            }
            if(adj.containsKey(i)) {
              boolean resp =   checkIfCycliC(adj, i, recStack);
              if (resp) return 0;
            }
        }
        return 1;
    }

    public  static  void  main(String[] args) {
        CourseCompletion courseCompletion = new CourseCompletion();
        ArrayList<Integer> ar = new ArrayList<>();
        ArrayList<Integer> br = new ArrayList<>();

        ar.add(1);
        ar.add(3);
        ar.add(4);
        ar.add(5);

        br.add(2);
        br.add(1);
        br.add(5);
        br.add(3);

        courseCompletion.solve(5, ar,br);
    }

}
