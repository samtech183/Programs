import java.util.ArrayList;
import java.util.List;

public class MaxProductSum {

    static public int maxProduct(final List<Integer> A) {
        int mini = A.get(0);
        int maxi = A.get(0);
        int ans = -100000;
        ans = Math.max(ans , Math.max(mini , maxi));
        int n = A.size();
        for(int i=1;i<n;i++) {
            int val = A.get(i);
            if(val>0) {
                mini = mini * val;
                maxi = maxi * val;
                ans = Math.max(ans ,  Math.max(mini , maxi));
            }
            else if(val < 0) {
                maxi = 1;
                mini = mini * val;
                maxi = Math.max(maxi , mini);
                ans = Math.max(ans , mini);

            }
            else {
                mini = 1;
                maxi = 1;
                ans = Math.max(ans , 0);
            }
        }
        return ans;
    }

    public  static  void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(-2);
        test.add(4);
        test.add(-2);
        test.add(5);
        int k  = 4;
        int sam = 1<<(k-1);
        System.out.println(1<<(k-1));

        maxProduct(test);
    }

}
