import java.sql.Time;
import java.util.*;

public class TimeToUpdate {

    class Nd {
        int node;
        int val;
        public Nd(int a,int b) {
            node = a;
            val = b;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<manager.length;i++) {
            if(map.containsKey(manager[i])) {
                map.get(manager[i]).add(i);
            }
            else {
                ArrayList<Integer> adj = new ArrayList<>();
                adj.add(i);
                map.putIfAbsent(manager[i] , adj);
            }
        }

        Queue<Nd> queue = new LinkedList<>();
        queue.add(new Nd(headID , 0));
        int level = 0;
        int ans = 0;
        int finalAns= Integer.MIN_VALUE;
        int curr = 1;
        int next = 0;
       // int runningMax = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            Nd node = queue.poll();
            List<Integer> adjs = map.get(node.node);
            if(adjs!=null && !adjs.isEmpty()) {
                for(Integer adjNode : adjs) {
                    queue.add(new Nd(adjNode, node.val + informTime[node.node]));
                    next++;
                }
            }
            else {
                ans = Math.max(node.val , ans);
            }
            curr--;
            if(curr==0) {
                level++;
                curr=next;
                next=0;

            }
        }
        return ans;
    }

    public static void main(String[] args)
    {

        int[] a = {5,9,6,10,-1,8,9,1,9,3,4};
        int[] b= {0,213,0,253,686,170,975,0,261,309,337};
        LinkedList<Integer> val = new LinkedList<>();
        val.add(100);
        val.add(200);
        val.remove(200);

        TimeToUpdate timeToUpdate = new TimeToUpdate();
        timeToUpdate.numOfMinutes(11,4,a,b);

    }

}
