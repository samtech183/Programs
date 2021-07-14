import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//todo - wrong solution
class Sol {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }
}

public class SplitArray {
    class SubArr {
        int start;
        int end;
        Integer val;
        int sum(int a, int b) {
            return a+b;
        }
        public SubArr(int a,int b,int c) {
            start = a;
            end = b;
            val = c;
        }
    }

    class compare implements Comparator<SubArr> {
        @Override
        public int compare(SubArr o1, SubArr o2) {
            return o2.val.compareTo(o1.val);
        }
    }


    private void split(int start , int end , int[] nums, PriorityQueue<SubArr> priorityQueue) {
        int sum = 0;
        for(int i=start;i<=end;i++) {
            sum += nums[i];
        }
        int splitSum = nums[start];
        int reqLeftSum = nums[start];
        int miniMax = Math.max(nums[start], (sum - splitSum));
        int reqIndex = start;
        for(int i=start+1;i<end;i++) {
            splitSum+=nums[i];
            int rightSum = sum - splitSum;
            int maxi = Math.max(splitSum , rightSum);
            if(miniMax > maxi) {
                miniMax= maxi;
                reqLeftSum = splitSum;
                reqIndex = i;
            }
        }

        SubArr subArr = new SubArr(start , reqIndex , reqLeftSum);
        SubArr subArr1 = new SubArr(reqIndex + 1 , end , sum - reqLeftSum);
        priorityQueue.add(subArr);
        priorityQueue.add(subArr1);
    }

    public int splitArray(int[] nums, int m) {

        PriorityQueue<SubArr> priorityQueue = new PriorityQueue<>(new compare());
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        SubArr subArr = new SubArr(0 , nums.length-1 , sum);
        priorityQueue.add(subArr);
        //List<SubArr> noDiv = new ArrayList<>();

        int ans = -1;

        while (m>1) {
            SubArr sub = priorityQueue.poll();

            if(sub==null) {
                break;
            }

            if(sub.start==sub.end) {
                ans = Math.max(ans , sub.val);
               // noDiv.add(sub);
            }


            while(sub.start==sub.end) {
                sub = priorityQueue.poll();
                if(sub==null) {
                    break;
                }

                if(sub.start==sub.end) {
                    ans = Math.max(ans , sub.val);
                }
            }

            split(sub.start , sub.end , nums , priorityQueue);
            m--;
        }

        SubArr subArr1 = priorityQueue.poll();
        ans = Math.max(subArr1.val , ans);
        return ans;
    }





    public static void main(String[] args) {
        int[] input = new int[11];
        input[0] = 7;
        input[1] = 2;
        input[2] = 5;
        input[3] = 10;


        input[6] = 6;
        input[7] = 7;
        input[8] = 19;
        input[9] = 10;
        input[10] = 10;
        SplitArray splitArray = new SplitArray();
        Sol sol = new Sol();
       int ans = sol.splitArray(input,6);
      //  int ans =  splitArray.splitArray(input , 6);
        int resp = ans;


    }
}
