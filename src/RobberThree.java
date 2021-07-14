import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RobberThree {


    int[] dp = new int[12000];

    public int solve(int index , int[] arr) {
        int n = arr.length;
        if(dp[index]!=0) return dp[index];
        if(index>n-1)
            return 0;
        if(index==n-1) {
            return arr[n-1];
        }

        int val1 = arr[index] + solve(index + 2 , arr);
        int val2 = solve(index+1 , arr);
        dp[index] = Math.max(val1 , val2);
        return  dp[index];
    }

    public int rob(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curr = 1;
        int next = 0;

        int evenSum = 0;
        int oddSum = 0;
        int level = 1;

        HashMap<Integer,Integer> levelSum = new HashMap<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left!=null) {
                queue.add(node.left);
                next++;
            }

            if(node.right!=null) {
                queue.add(node.right);
                next++;
            }

            curr--;

            if(!levelSum.containsKey(level)) {
                levelSum.put(level , node.val);
            }
            else {
                levelSum.put(level ,  levelSum.get(level) + node.val);
            }

            if(curr==0) {
                level++;
                curr = next;
                next = 0;
            }
        }

        int [] levelArr = new int[level];

        for(Integer levels : levelSum.keySet()) {
            levelArr[levels] = levelSum.get(levels);
        }

        int ans = solve(0, levelArr);
        return  ans;
    }

    public static  void main(String [] args) {


        int ans = new RobberThree().rob(null);



    }

}
