import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForce1 {

    static int[] arr = {2,3,2,3,2};
    static int mod =  1000000007;

    static int getSum(long n) {
        int sum =0;
        for(int i=0;i<n;i++) {
            sum+=arr[i];
        }
        return sum;
    }

    static long moduloMultiplication(long a, long b, long mod)
    {

        long res = 1;

        // Update a if it is more than
        // or equal to mod
        a %= mod;

        while (b > 0)
        {

            // If b is odd, add a with result
            if ((b & 1) > 0)
            {
                res = (res + a) % mod;
            }

            // Here we assume that doing 2*a
            // doesn't cause overflow
            a = (2 * a) % mod;

            b >>= 1; // b = b / 2
        }
        return res;
    }
    public static void main(String []  args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int t = myObj.nextInt();
        while(t!=0) {
            long n = myObj.nextLong();
            //n=n%mod;
           // System.out.print(n + " ");
            int sum = 12;
            long q = n/6;
            long r = n%6;
            long rsum = getSum(r);

            long sum1 = q/2;

            long sum2 = q-sum1;

            long sumfive = moduloMultiplication(sum1,5,mod);

            long sumfour = moduloMultiplication(sum2,4,mod);

            long qsum  = moduloMultiplication(q,sum,mod);
            long normaL = q*sum;

            long ans = ((((qsum-1)%mod + rsum%mod)%mod + (sumfive-1)%mod)%mod + (sumfour-1)%mod)%mod;
            System.out.println(ans);
            t--;
        }
    }
}
