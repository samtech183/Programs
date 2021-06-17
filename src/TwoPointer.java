import java.util.*;

public class TwoPointer {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int start = 0;
        int end = 0;
        int n = A.size();
        while(start < n && end < n) {
            int diff = Math.abs(A.get(start) - A.get(end));
            if((Math.abs(B)==diff) && start  != end) {
                return 1;
            }
            if(Math.abs(B) > diff) {
                end++;
            }

            if(Math.abs(B) < diff) {
                start++;
            }
        }
        return 0;
    }

    public ArrayList<Integer> solveit(ArrayList<Integer> A, int B) {
        Collections.sort(A , Comparator.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>(A.subList(0 , B));
        return ans;
    }

    public static int perfectPeak(ArrayList<Integer> A) {
        List<Integer> maxTillNow = new ArrayList<>();
        List<Integer> minFromRight = new ArrayList<>();

        int n = A.size();
        int maxi = 0;
        for(int i=0;i<n;i++) {
            maxi = Math.max(maxi , A.get(i));
            maxTillNow.add(maxi);
        }

        int mini = 2000000000;
        for(int i = n-1;i>=0;i--) {
            mini = Math.min(mini , A.get(i));
            minFromRight.add(mini);
        }
        Collections.reverse(minFromRight);

        if(minFromRight.get(1) > A.get(0)) return 1;
        if(maxTillNow.get(n-1) < A.get(n-1)) return 1;

        for(int i=1;i<n-1;i++) {
            int val = A.get(i);
            if((val > maxTillNow.get(i-1)) && (val < minFromRight.get(i+1))) {
                return 1;
            }
        }

        return 0;
    }
    public static void main(String [] args) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(5);
        values.add(1);
        values.add(4);
        values.add(3);
        values.add(6);
        values.add(8);
        values.add(10);
        values.add(7);
        values.add(9);
        perfectPeak(values);

    }


}
