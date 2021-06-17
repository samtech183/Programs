//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
////Node {
////    int data;
////    Node * next;
////}
//
//
//class Node {
//   public Integer data;
//
//   public  Integer getData() {
//       return data;
//   }
//    public  void setData(int val) {
//         data = val;
//    }
//   public Node nextNode;
//
//    public  void setNext(Node node) {
//        nextNode = node;
//    }
//    public  Node getNext() {
//        return nextNode;
//    }
//}
//
//class Link {
//
//    Node lastNode = null;
//    Node firstNode = null;
//
//    public  void addNode(int val) {
//        Node node= new Node();
//        node.setData(val);
//        node.setNext(null);
//        //3.next , 5(lastNode)
//        if(lastNode==null) {
//            lastNode = node;
//            firstNode = node;
//        }
//        else {
//            lastNode.setNext(node);
//            lastNode = node;
//        }
//    }
//    //addCycle(10,7)
//
//    public void addCycle(Node node1 , Node node2) {
//        node1.setNext(node2);
//    }
//
//    public void iterate() {
//        if(firstNode==null) {
//            return;
//        }
//        Node itr = firstNode;
//        while(itr!=null) {
//            System.out.println(itr.data);
//            itr = itr.getNext();
//        }
//    }
//
//    public Node getNodeAtPos(int pos) {
//        if(firstNode==null) {
//            return null;
//        }
//        Node itr = firstNode;
//        while(pos!=0) {
//            System.out.println(itr.data);
//            itr = itr.getNext();
//            pos--;
//        }
//        return itr;
//    }
//
//    public boolean checkCycle(Node node) {
//        Node slow = node.getNext();
//        if(slow==null){
//            return false;
//        }
//        Node fast = node.getNext().getNext();
//
//        while(true) {
//            if(slow==null){
//                return false;
//            }
//            if(fast==null){
//                return false;
//            }
//            if(slow.equals(fast)) {
//                System.out.println("Cycle exists ");
//                return true;
//            }
//            slow = slow.getNext();
//
//            fast = fast.getNext();
//            if(fast!=null){
//                fast = fast.getNext();
//            }
//            else {
//                return false;
//            }
//        }
//    }
//}
//
//
//
//
//
//
