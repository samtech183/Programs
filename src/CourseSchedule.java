import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {

    HashMap<Integer , List<Integer>> adj = new HashMap<>();
    boolean[] vis = new boolean[100001];
    boolean[] recStack = new boolean[100001];
    boolean isPossible = true;
    int [] parent = new int[100001];
    List<Integer> fi = new ArrayList<>();
    HashMap<Integer , List<Integer>> par = new HashMap<>();

    void dfs(int courseNo) {
        if(recStack[courseNo]) {
            isPossible = false;
        }
        if(vis[courseNo])
            return;
        recStack[courseNo] = true;
        vis[courseNo] = true;
        List<Integer> nbrs = adj.get(courseNo);
        if(nbrs!=null && !nbrs.isEmpty()) {
            for(Integer val : nbrs) {
                if(par.containsKey(val)) {
                    par.get(val).add(courseNo);
                }
                else {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(courseNo);
                    par.put(val , lst);
                }
                dfs(val);
            }
        }
        recStack[courseNo] = false;
    }

    void createOrder(int courseNo) {

        if(fi.contains(courseNo)) {
            return;
        }
        List<Integer> nbrs = par.get(courseNo);
        if(nbrs!=null && !nbrs.isEmpty()) {
            for(Integer val : nbrs) {
                createOrder(val);
            }
        }
        if(!fi.contains(courseNo))
            fi.add(courseNo);

    }



    public int[] canFinish(int numCourses, int[][] prerequisites) {

        for(int i=0;i<numCourses;i++) {
            parent[i] = i;
        }

        int n = prerequisites.length;
        for(int i=0;i<n;i++) {
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            if(adj.containsKey(start)) {
                adj.get(start).add(end);
            }
            else {
                List<Integer> lst = new ArrayList<>();
                lst.add(end);
                adj.put(start , lst);
            }
        }

        for(int i=0;i<numCourses;i++) {
            dfs(i);
        }

        if(!isPossible) {
            return new int[4];
        }

        for(int i=0;i<numCourses;i++) {
            createOrder(i);
        }

        int size = fi.size();
        int[] ans = new int[size];
        for(int i=0;i<size;i++) {
            ans[i] = fi.get(i);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
        CourseSchedule cs =new CourseSchedule();
        cs.canFinish(4,pre);
    }
}
