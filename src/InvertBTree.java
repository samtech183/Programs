import java.util.ArrayList;
import java.util.List;

public class InvertBTree {

    public static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  public TreeNode rec(TreeNode node) {
        if(node==null) {
            return null;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.right = rec(left);
        node.left = rec(right);
        return  node;
  }

    public TreeNode invertTree(TreeNode root) {
        List<TreeNode> s = new ArrayList<>();
       return rec(root);
    }

    public  static  void main(String[] args) {
        TreeNode node = new TreeNode(1,null,null);
        InvertBTree iv  = new InvertBTree();
        iv.invertTree(node);
    }
}
