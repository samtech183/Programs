import java.util.*;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class kStopsFlight {
    static class NodeFlight {
        Integer node;
        Integer val;
        public NodeFlight(int a, int b) {
            node =a;
            val = b;
        }
    }
    static class Po {
        Integer val;
        int node;
        int lvl;
        public Po(int a, int b,int c) {
            node =a;
            val = b;
            lvl = c;
        }

    }

    class pqComp implements Comparator<Po> {
        @Override
        public int compare(Po o1, Po o2) {
            return o1.val.compareTo(o2.val);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] levels = new int[n];
        int[] dist = new int[n];
        for(int i=0;i<n;i++) {
            dist[i] = Integer.MAX_VALUE;
            levels[i] = Integer.MAX_VALUE;
        }

        HashMap<Integer, List<NodeFlight>> adj = new HashMap<>();

        int len = flights.length;

        for(int i=0;i<len;i++) {
            int start = flights[i][0];
            int end = flights[i][1];
            int val = flights[i][2];

            NodeFlight dest = new NodeFlight(end , val);
            if(!adj.containsKey(start)) {
                List<NodeFlight> list = new ArrayList<>();
                list.add(dest);
                adj.put(start , list);
            }
            else {
                adj.get(start).add(dest);
            }
        }
        PriorityQueue<Po> pq = new PriorityQueue<>(new pqComp());
        pq.add(new Po(src,0 , 1));
        levels[src] = 1;
        dist[src] = 0;
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Po nod = pq.poll();
            int node = nod.node;

            int dis = nod.val;
            int currLevel = nod.lvl;
            if(node==dst) {
                ans = Math.min(ans , dis);
            }
            List<NodeFlight> adjs = adj.get(node);
            if(adjs==null)
                continue;
            for(NodeFlight nf : adjs) {
                if(dist[nf.node] > dis + nf.val) {
                    if(currLevel+1 <= k+2) {
                        pq.add(new Po(nf.node , dis + nf.val , currLevel + 1));
                        levels[nf.node] = currLevel + 1;
                        dist[nf.node] = dis + nf.val;
                    }
                }
                else if(levels[nf.node] > currLevel+1 && currLevel+1 <= k+2) {
                    pq.add(new Po(nf.node , dis + nf.val , currLevel + 1));
                    levels[nf.node] = currLevel + 1;
                    //dist[nf.node] = dis + nf.val;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        kStopsFlight ks = new kStopsFlight();
        int ans = ks.findCheapestPrice(11,flights, 0,3,1);

    }
}
