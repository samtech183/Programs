import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class ZeroSum {
    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {

        int n = A.size();
        List<Integer> prefix = new ArrayList<>();
        prefix.add(0 , A.get(0));
        for(int i=1;i<n;i++) {
            prefix.add(i , prefix.get(i-1) + A.get(i));
        }

        Map<Integer , Integer> lastSeen = new HashMap<>();
        lastSeen.put(0 , -1);
        int maxi = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<n;i++) {
            if(lastSeen.containsKey(prefix.get(i))) {
               int val =  i - lastSeen.get(prefix.get(i)) + 1;
               if(val > maxi) {
                   start = lastSeen.get(prefix.get(i));
                   end = i;
                   maxi = val;
               }
            }
            else {
                lastSeen.put(prefix.get(i) ,i);
            }

        }
        System.out.println("ans is " + maxi +" start end "+ start + " " + end);
        return (ArrayList<Integer>) A.subList(start+1,end);
    }

    public static void main(String [] args) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(-3);
        values.add(3);
       ArrayList<Integer> ans = lszero(values);
       System.out.println(ans);
    }
}
