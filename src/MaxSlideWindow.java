import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxSlideWindow {


    static Long rec(Long x,int n) {
        if(n==1){
            return x;
        }
        if(n%2==1) {
            return x * rec(x , n-1);
        }
        return rec(x*x , n/2);
    }
    public static int pow(int x, int n, int d) {
        if(x==0) return 0;
        if(n==0) return 1;
        Long ans = rec((long)x, n);
        int fiAns = (int) (ans%d);
        if(fiAns<0) {
            return fiAns+=d;
        }
        return fiAns;
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int index = 0;
        int n = A.size();
        while(index<n) {
            int val = A.get(index);
            while(!deque.isEmpty() && A.get(deque.getLast()) < val) {
                deque.removeLast();
            }
            deque.add(index);

            if(index>=B-1) {
                while(!deque.isEmpty() && deque.getFirst() <= (index - B)){
                    deque.removeFirst();
                }
                ans.add(A.get(deque.getFirst()));
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int val = (-1)%20;
        pow(-1,1,20);
//        ArrayList<Integer> ans = new ArrayList<>();
//        ans.add(10);
//        ans.add(9);
//        ans.add(8);
//        slidingMaximum(ans, 2);

    }

}
