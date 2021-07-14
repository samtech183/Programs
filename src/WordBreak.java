import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    int[] memo = new int[4];

    public  boolean rec(String s, int index, String curr , Map<String , Boolean> map) {

        if(memo[index]!=0) {
            return memo[index]==1;
        }
        boolean resp = false;
        for(int i=index;i<s.length();i++) {
            curr=curr + s.charAt(i);
            if(map.containsKey(curr)) {
                if(i==s.length()-1) {
                  return true;
                }
               resp = resp || rec(s,i+1,"",map);
            }
        }
        if(resp)
            memo[index] = 1;
        else
            memo[index] = -1;

        return resp;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Boolean> map = new HashMap<>();
        for(String word : wordDict) {
            map.put(word , true);
        }
        boolean ans = rec(s,0,"",map);
        return ans;
    }

    public  static void main(String[] args){
        String s = "aaaaaaa";
        List<String> sam = new ArrayList<>();
        sam.add("aa");
        sam.add("aaaaa");
        WordBreak wb = new WordBreak();
        wb.wordBreak(s,sam);

        System.out.println(wb.memo[0]);
        System.out.println("sa");
    }
}
