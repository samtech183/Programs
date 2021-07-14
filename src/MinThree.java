import java.util.Arrays;
import java.util.Collections;

public class MinThree {

    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n<5){
            return 0;
        }
        int ans = 10000000;

        for(int i=0;i<=3;i++) {

            int mini = nums[3-i];
            int maxi = nums[n-1-i];

            ans = Math.min(ans , maxi - mini);

        }

        return ans;
    }
}
