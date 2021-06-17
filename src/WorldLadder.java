import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class WorldLadder {

    ArrayList<ArrayList<String>> ans = new ArrayList<>();

    static int diff(String arr1, String arr2) {
        int n = arr1.length();
        int count = 0;
        for(int i=0;i<n;i++) {
            if(arr1.charAt(i)!=arr2.charAt(i)) count++;
        }
        return count;

    }

    void dfs(String start , String end , Map<String, List<String>> adj , String pathen, Map<String, Integer> rec,int currLevel, int maxLevel) {

        if(diff(start,end)==1) {
            ArrayList<String> newAns = new ArrayList<>(Arrays.asList(pathen.split("_")));
            newAns.add(end);
            ans.add(newAns);
            return;
        }

        if(currLevel>=maxLevel){
            return;
        }

        if(rec.containsKey(start)) {
            return;
        }
        rec.put(start,1);

        List<String> lst = adj.get(start);
        for(String key : lst) {
            dfs(key,end,adj,pathen.concat("_").concat(key),rec,currLevel+1,maxLevel);
        }

        rec.remove(start);
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        Collections.sort(dict);

        if(start.equals(end)) {
            ArrayList<String> ask = new ArrayList<>();
            ask.add(start);
            ans.add(ask);
            return ans;
        }
        dict.add(end);
        Map<String, List<String>> child = new HashMap<>();
        child.put(start , new ArrayList<>());
        child.put(end, new ArrayList<>());

        for(int i=0;i<dict.size();i++) {
            child.put(dict.get(i) , new ArrayList<>());
        }

        String paths = start;

        Queue<String> queue = new LinkedList<>();
        queue.add(start);



        int currCount = 1;
        int nextLevelCount = 0;
        int level=0;
        int maxLevel = -1;
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if(diff(node,end)==1) {
                maxLevel = level;
            }

            for(int i=0;i<dict.size();i++) {
                int diff = diff(node , dict.get(i));
                String val = dict.get(i);
                if(diff==1) {
                    if(!child.get(node).contains(val)) {
                        child.get(node).add(dict.get(i));
                        queue.add(dict.get(i));
                        nextLevelCount++;
                    }
                }
            }

            currCount--;
            if(currCount==0) {
                level++;
                if(level>maxLevel && maxLevel!=-1) break;
                currCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }


        Map<String, Integer> rec = new HashMap<>();
        dfs(start,end,child,start,rec,0,maxLevel);

        return ans;
    }

    public static void main(String [] args) {
        ArrayList<String> check = new ArrayList<>();
        check.add("baba");
        check.add("abba");
        check.add("aaba");
        check.add("bbbb");
        check.add("abaa");
        check.add("abab");
        check.add("aaab");
        check.add("abba");
        check.add("abba");
        check.add("abba");
        check.add("bbba");
        check.add("aaab");
        check.add("abaa");
        check.add("baba");
        check.add("baaa");

//        char s = 's';
//        int val = s - 'a';
//        val ++;
//        char ch = (char) (val + 'a');
//        int xs = 10;
        WorldLadder worldLadder = new WorldLadder();
        worldLadder.findLadders("bbaa","bbab",check);

    }
}
