import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
    }
}

public class RootToLeaf {

    int ans = 0;

    void rec(TreeNode A , String s) {

        if(A.left==null && A.right==null) {
            System.out.println("S is "+ s);
            s = s+A.val;
            Integer val = Integer.parseInt(s);
            ans+=val;
            return;
        }

        String next = s + A.val;
        int val = Integer.parseInt(next);
        Integer x = val % 1003;

        next = x.toString();

        if(A.left!=null)
            rec(A.left , next);
        if(A.right!=null)
            rec(A.right , next);
    }

    public int sumNumbers(TreeNode A) {
        rec(A,"");
        return ans % 1003;
    }

    boolean solve (TreeNode A, int sum) {
        if(A==null) return false;
        if(A.left==null && A.right==null) {
            sum = sum - A.val;
            if(sum==0) return  true;
            return false;
        }

        boolean resp = false;
        resp = resp || solve(A.left , sum-A.val);
        resp = resp || solve(A.right, sum - A.val);

        return resp;
    }

    public int hasPathSum(TreeNode A, int B) {
        if(solve(A,B)) return 1;
        return 0;
    }



    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {


        Queue<TreeNode> qu  = new LinkedList<>();
        qu.add(A);
        Map<Integer  , List<Integer>> levelVal = new HashMap<>();

        int level = 1;
        int currCount = 1;
        int nextCount = 0;
        while(!qu.isEmpty()) {

            TreeNode node = qu.poll();
            levelVal.putIfAbsent(level , new ArrayList<>());
            levelVal.get(level).add(node.val);

            if(node.left!=null) {
                qu.add(node.left);
                nextCount++;
            }
            if(node.right!=null) {
                qu.add(node.right);
                nextCount++;
            }

            currCount--;
            if(currCount==0) {
                level++;
                currCount = nextCount;
                nextCount = 0;
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(Integer levels : levelVal.keySet()) {
            if(levels%2==0) {
                Collections.reverse(levelVal.get(levels));
                ArrayList<Integer> list = new ArrayList<>(levelVal.get(levels));
                ans.add(list);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>(levelVal.get(levels));
                ans.add(list);
            }
        }

        return ans;
    }


    public static void main(String args[])
    {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.left.right = new TreeNode(5);

        RootToLeaf rootToLeaf = new RootToLeaf();
        rootToLeaf.zigzagLevelOrder(treeNode);
    }
}
