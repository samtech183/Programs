import java.util.ArrayList;
import java.util.List;

public class GasTanks {

    public  static int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {

        int n = A.size();
        int[] diff = new int[n];
        int[] back = new int[n];
        int[] front = new int[n];


        int sum = 0;
        for(int i=0;i<A.size();i++) {
            int dif =  A.get(i) - B.get(i);
            diff[i] = dif;
            sum += dif;
        }
        if(sum<0) return -1;

        int currSum = 0;
        int ans = -1;
        for(int i=0;i<n;i++) {

            if(currSum<0) {
                currSum=0;
                ans = -1;
            }
            if(diff[i]>=0) {
                if(currSum==0) {
                    ans = i;
                }
            }

            currSum+=diff[i];
        }

        return ans;
    }

    public static void main(String []  args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(2);
        b.add(2);
        b.add(1);

       int ans =  canCompleteCircuit(a,b);
    }
}
