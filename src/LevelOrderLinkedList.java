import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

public class LevelOrderLinkedList {

    public void connect(TreeLinkNode root) {

        Queue<TreeLinkNode> qu = new LinkedList<>();
        qu.add(root);
        int currCount = 1;
        int nextCount = 0;

        TreeLinkNode lastNode = null;

        while (!qu.isEmpty()) {

            TreeLinkNode treeLinkNode = qu.poll();
            if(lastNode!=null)
                lastNode.next = treeLinkNode;

            lastNode = treeLinkNode;

            if(treeLinkNode.left!=null) {
                qu.add(treeLinkNode.left);
                nextCount++;
            }
            if(treeLinkNode.right!=null) {
                qu.add(treeLinkNode.right);
                nextCount++;
            }

            currCount--;
            if(currCount==0) {
                treeLinkNode.next=null;
                currCount = nextCount;
                nextCount = 0;
                lastNode=null;
            }
        }

        System.out.println(root);
    }

    public static void main(String args[])
    {
        TreeLinkNode treeNode = new TreeLinkNode(1);
        treeNode.left = new TreeLinkNode(2);
        treeNode.left.left = new TreeLinkNode(7);
        treeNode.right = new TreeLinkNode(3);
        treeNode.right.left = new TreeLinkNode(4);
        treeNode.right.left.right = new TreeLinkNode(5);

        LevelOrderLinkedList levelOrderLinkedList = new LevelOrderLinkedList();
        levelOrderLinkedList.connect(treeNode);
    }
}
