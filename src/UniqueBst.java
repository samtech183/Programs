//https://leetcode.com/problems/unique-binary-search-trees/
public class UniqueBst {

    int[] dp = new int[100];

    int rec(int n) {
        if(n==2) {
            return 2;
        }
        if(n==1) {
            return 1;
        }
        if(n==0)
            return 1;
        if(dp[n]!=0) {
            return dp[n];
        }
        int sum = 0;
        for(int i=0;i<n;i++) {
            int val1 = n-1-i;
            int val2 = i;
            if(val1>val2) {
                sum += 2*(rec(val1)*rec(val2));
            }
            else if(val1==val2){
                sum += rec(val1) * rec(val2);
                break;
            }
            else {
                break;
            }
        }
        dp[n] = sum;
        return sum;
    }

    public int numTrees(int n) {
        int ans = rec(n);
        return ans;
    }

    public static void main(String[] args) {
        UniqueBst uniqueBst = new UniqueBst();
        uniqueBst.numTrees(6);
    }
}
