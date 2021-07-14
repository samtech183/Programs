public class SearchInRotatedSorted {


    static boolean checkInRangeLeft(int start,int end,int target) {
        if(target>=start && target<end) {
            return true;
        }
        return false;
    }

    static boolean checkInRangeRight(int start,int end,int target) {
        if(target>=start && target<=end) {
            return true;
        }
        return false;
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end) {

            int mid = start + (end-start)/2;

            int startVal = nums[start];
            int endVal = nums[end];
            int midVal = nums[mid];
            if(target==midVal) return mid;
            if(startVal<midVal) {
                boolean resp =  checkInRangeLeft(startVal, midVal , target);
                if(resp) {
                    end = mid-1;
                }
                else {
                    start=  mid+1;
                }
            }
            else {
                if(mid+1<nums.length) {
                    boolean resp =  checkInRangeRight(nums[mid+1], endVal , target);
                    if(resp) {
                        start = mid+1;
                    }
                    else {
                        end=  mid-1;
                    }
                }
                else {
                   return -1;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[2];
        nums[0]=3;
        nums[1]=1;


        search(nums, 1);




    }
}
