public class ArrayPartition {

    int[] dp = new int[1000];

    int rec(int index , int[] arr, int k) {
        int n = arr.length;
        if(index==n-1) {
            return arr[n-1];
        }
        if(index==n)
            return 0;
        if(dp[index]!=0) {
            return dp[index];
        }
        int max = Integer.MIN_VALUE;
        int maxi=Integer.MIN_VALUE;
        for(int i=index;i<index+k && i<n;i++) {
            max = Math.max(max  ,arr[i]);
            int resp = rec(i+1,arr,k);
            int val =  resp + (i-index+1)*max;
            maxi = Math.max(maxi , val);
        }
        dp[index] = maxi;
        return maxi;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int ans = rec(0,arr,k);
        return ans;
    }

    public static void main(String[] args)
    {
        int[] a = {1,15,7,9,2,5,10};
        ArrayPartition ap = new ArrayPartition();
        ap.maxSumAfterPartitioning(a,3);


    }
}
