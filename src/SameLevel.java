import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;



public class SameLevel {

    static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }

    public static int sumOfLeftView(Node root)
    {
        Integer currCount = 0;
        Integer nextCount = 0;
        if(root==null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        currCount = 1;
        //Node lastNode = null;
        Map<Integer, Integer> levelToVal = new HashMap<>();

        while(!q.isEmpty()) {
            Node node = q.poll();
            currCount--;

            if(!levelToVal.containsKey(level)) {
                levelToVal.put(level , node.data);
            }

            if(node.left!=null) {
                q.add(node.left);
                nextCount++;
            }
            if(node.right!=null) {
                q.add(node.right);
                nextCount++;
            }
            if(currCount==0) {
                node.right=null;
                currCount=nextCount;
                nextCount=0;
                level++;
            }
        }

        int ans = 0;
        for(Integer lev : levelToVal.keySet()) {
            System.out.println("level "+ lev + " has first element " + levelToVal.get(lev));
            ans += levelToVal.get(lev);
        }
        return ans;
    }

    public static  void main(String [] args) {
        Node node = new Node(10);
        node.left = new Node(111);
        node.right = new Node(511);
        node.left.left = new Node(11);
        node.left.right = new Node(12);
        node.left.left.left = new Node(14);
        node.left.left.left.left = new Node(18);
        node.right.right = new Node(20);
        node.right.left = new Node(100);

        int ans = sumOfLeftView(node);



    }
}
