import java.util.*;

public class LongestChain {

    TreeMap<Integer , List<String>> map = new TreeMap<>();
    HashMap<String,Integer> memo = new HashMap<>();

    boolean isPredecessor(String prev , String next) {
        int n = next.length();
        int index = 0;
        for(int i=0;i<n;i++) {
            if(index>=n-1) break;
            char charP = prev.charAt(index);
            char charN = next.charAt(i);
            if(charN==charP) {
                index++;
            }

        }

        if(index==n-1) {
            return true;
        }
        return false;
    }

    int dfs(String curr) {
        int len = curr.length();
        if(memo.containsKey(curr)) {
            return memo.get(curr);
        }
        List<String> adjs = map.get(len + 1);
        if(adjs==null || adjs.isEmpty()) {
            return 1;
        }
        int maxi = 1;
        for(String adj : adjs) {
            boolean resp = isPredecessor(curr , adj);
            if(resp) {
                int val = 1+dfs(adj);
                maxi = Math.max(val , maxi);
            }
        }
        memo.put(curr , maxi);
        return maxi;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        for(int i=0;i<n;i++) {
            int len = words[i].length();
            if(map.containsKey(len)) {
                map.get(len).add(words[i]);
            }
            else {
                List<String> adjs = new ArrayList<>();
                adjs.add(words[i]);
                map.put(len, adjs);
            }
        }

        Set<Integer> lengths = map.keySet();
        int maxi = Integer.MIN_VALUE;

        for(Integer len : lengths) {
            List<String> startList = map.get(len);
            for(String star : startList) {
                 maxi  =  Math.max(dfs(star) , maxi);
            }
        }
        return maxi;
    }


    public static void main(String[] args)
    {

        String[] str = {"a","b","ab","bac"};

        LongestChain longestChain = new LongestChain();
        longestChain.longestStrChain(str);

    }
}
