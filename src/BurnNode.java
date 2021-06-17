import java.util.*;

class Node {
    Node left;
    Node right;
    Integer val;
    List<Integer> lst;
    public Node(Integer val) {
        this.val = val;
        lst = new ArrayList<>();
    }
}


public class BurnNode {

    public static int solve(Node node , int val, Map<Integer , Set<Node>> levelMap) {
        if(node != null) {
            if(node.val == val) {
                levelMap.put(1  , new HashSet<>());
                levelMap.get(1).add(node);
                burlAllBelow(node.left, levelMap, 2);
                burlAllBelow(node.right, levelMap, 2);
                return 2;
            }

            int resp = solve(node.left , val,  levelMap);
            if(resp > 0) {
                if(levelMap.containsKey(resp)) {
                    levelMap.get(resp).add(node);
                }else {
                    levelMap.put(resp  , new HashSet<>());
                    levelMap.get(resp).add(node);
                }
                burlAllBelow(node.right, levelMap, resp+1);
                return resp +1;
            }

            int resp2 = solve(node.right , val , levelMap);
            if(resp2 > 0) {
                if(levelMap.containsKey(resp2)) {
                    levelMap.get(resp2).add(node);
                }else {
                    levelMap.put(resp2  , new HashSet<>());
                    levelMap.get(resp2).add(node);
                }
                burlAllBelow(node.left, levelMap, resp2+1);
                return resp2+1;
            }
        }
        return 0;
    }

    public static void burlAllBelow(Node node, Map<Integer , Set<Node>> levelMap , int k) {
        if(node!=null) {
            if(levelMap.containsKey(k)) {
                levelMap.get(k).add(node);
            }else {
                levelMap.put(k  , new HashSet<>());
                levelMap.get(k).add(node);
            }
            burlAllBelow(node.left , levelMap , k+1);
            burlAllBelow(node.right, levelMap , k+1);
        }
    }


    public  static  void main(String [] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(21);
        node.left.left = new Node(34);
        node.left.right = new Node(11);
        node.right.left = new Node(12);
        node.right.right = new Node(102);
        node.left.left.left = new Node(100);

        Map<Integer , Set<Node>> levelMap = new HashMap<>();
        solve(node, 20 , levelMap);
        for(Integer val : levelMap.keySet()) {
            Set<Node> nodes = levelMap.get(val);
            System.out.println(val);
            for(Node nn : nodes) {
                System.out.println(nn.val + " , ");
            }
            System.out.println("--------------");
        }
        System.out.println(levelMap);
    }


}
