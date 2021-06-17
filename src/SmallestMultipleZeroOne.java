import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SmallestMultipleZeroOne {


    int getMod(int a,String num) {
        int res = 0;
        for (int i = 0; i < num.length(); i++)
            res = (res * 10 + (int)num.charAt(i) - '0') % a;

       return res;
    }

    public String multiple(int A) {
        Set<Integer> visit = new HashSet<>();
        String num = "1";
        Queue<String> qu = new LinkedList<>();
        qu.add(num);

        while(!qu.isEmpty()) {
            String n = qu.poll();
            //int B = Integer.parseInt(n);
            int mod = getMod(A,n);
            if(mod==0) return n;
            if(!visit.contains(mod)) {
                visit.add(mod);
                String s1 = n.concat("0");
                String s2 = n.concat("1");
                qu.add(s1);
                qu.add(s2);
            }
        }
        return "-1";
    }
}
