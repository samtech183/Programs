public class MaximumWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;

        int ans = -1;
        while(start < end) {
            int min = Math.min(height[start] , height[end]);
            ans = Math.max(min * (end-start), ans);
            if(min==height[start]) {
                start++;
            }
            else {
                end--;
            }
        }

        return  ans;
    }

}
