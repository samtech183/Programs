public class MissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int positive = 0;
        int n = nums.length;
        boolean one = false;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==1) {
                one = true;
            }
            if(nums[i] > 0) {
                positive++;
            }
           else {
                nums[i] = 1;
            }
        }
        if(!one) return 1;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] > positive) {
                nums[i] = 1;
            }
        }

        for(int i=0;i<n;i++) {
            int val = Math.abs(nums[i]);
            if(nums[val-1]>0)
                nums[val-1] = -1*nums[val-1];
        }

        for(int i=1;i<=positive;i++) {
            if(nums[i-1]>0) {
                return i;
            }
        }

        return positive+1;
    }

    public static void main(String[] args) {
        int[] sam = new int[6];
        sam[0] = 1;
        sam[1] = 2;
        sam[2] = 8;
        sam[3] = 11;
        sam[4] = 12;
        sam[5] = 18;


      int ans =   firstMissingPositive(sam);
      int ma =1;


    }
}
