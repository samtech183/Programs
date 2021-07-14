


public class AddTwoNodes {

    static class Node {
        int data;
        Node next;
    }

    static int getSize(Node node) {
        int count = 0;
        Node check = node;
        while(check.next!=null) {
            check = check.next;
            count++;
        }
        return count;
    }

    static void movePlaces(Node node , int count) {
        while(count > 0) {
            node = node.next;
            count--;
        }
    }

    static int addTwo(Node first , Node second,Node result) {
        if(first==null || second==null) {
            return 0;
        }
        Node node = new Node();
        int rem  = addTwo(first.next , second.next , node);
        int sum = first.data + second.data + rem;
        int q = sum%10;

        int r = sum/10;
        node.data = r;
        if(result==null) {
            if(q !=0) {
                Node firstNode = new Node();
                firstNode.data = q;
                firstNode.next = node;
            }
            else {
                result = node;
            }
        }
        else {
            result.next = node;
        }
        return q;
    }

    static Node addTwoLists(Node first, Node second) {
        int size1 = getSize(first);
        int size2 = getSize(second);

        if(size1>size2) {
            movePlaces(first ,size1-size2);
        }
        else {
            movePlaces(second ,size2-size1);
        }

        Node result = null;
        addTwo(first , second , result);

        return result;
    }



 }
