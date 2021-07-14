import java.util.*;

//https://codeforces.com/contest/1541/problem/C
public class GreatGraph {
    public static void main(String []  args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int t = myObj.nextInt();
        while(t!=0) {
            int n = myObj.nextInt();
            List<Integer> input = new ArrayList<>();
            for(int i=0;i<n;i++) {
                int val = myObj.nextInt();
                input.add(val);
            }
            Collections.sort(input);
            long sum = 0;
            int prev = input.get(0);
            for(int i=1;i<n;i++) {
                sum += (input.get(i) - prev);
                prev = input.get(i);
            }

            long count = 1;
            long prefixSum = 0;
            long negativeSum = 0;
            for(int i=1;i<n;i++) {
                long val = count * input.get(i) - prefixSum;
                negativeSum += val;
                prefixSum += input.get(i);
                count++;
            }

            negativeSum = negativeSum * -1;
            long ans = sum + negativeSum;
            System.out.println(ans);
            t--;
        }
    }
}
