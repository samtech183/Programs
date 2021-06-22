import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

public class CardsSelect {


    HashMap<String , Integer> map = new HashMap<>();

    int rec(int[] points, int start, int end, int count, int sum) {
        if(count==0) {
           return sum;
        }
        String s = start + "_" + end;

        if(map.containsKey(s)) {
            return map.get(s);
        }
        int first = rec(points, start+1,end,count-1,sum+points[start]);
        int second =  rec(points, start,end-1,count-1,sum+points[end]);
        map.put(s, Math.max(first,second));
        return Math.max(first,second);
    }


    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = cardPoints[0];
        for(int i=1;i<n;i++) {
            left[i] = left[i-1] + cardPoints[i];
        }

        right[n-1] = cardPoints[n-1];
        for(int i=n-2;i>=0;i--) {
            right[i] = right[i+1] + cardPoints[i];
        }

        int index = k-1;
        int rightIndex = n-1;
        int ans = Math.max(left[index], right[n-k]);
        index--;


        while(index>=0) {
            int temp = left[index] + right[rightIndex];
            rightIndex--;
            index--;
            ans = Math.max(ans  , temp);
        }

        return ans;
         //int ans = rec(cardPoints,0,cardPoints.length-1,k,0);
        //return ans;
    }



    public static void main(String[] args) {
        int[] nums = new int[7];
        nums[0]=1;
        nums[1]=2;
        nums[2]=3;
        nums[3]=4;
        nums[4]=5;
        nums[5]=6;
        nums[6]=1;
        CardsSelect cardsSelect = new CardsSelect();
        cardsSelect.maxScore(nums,3);

    }
}
