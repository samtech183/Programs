import java.util.LinkedList;
import java.util.PriorityQueue;

public class Stacks {

    public Integer index;
    public LinkedList<Integer> stk;
    public LinkedList<Integer> minHelp;

    Stacks() {
        this.index = 0;
        this.stk = new LinkedList<>();
        this.minHelp = new LinkedList<>();
    }

    public void push(int x) {
        // System.out.println("---push -"+x);
        stk.add(x);
        if(!minHelp.isEmpty()) {
            minHelp.add(Math.min(minHelp.get(index), x));
        }
        else {
            minHelp.add(x);
        }
        index++;
    }

    public void pop() {
        if(stk.isEmpty()) return;
        int val =  stk.remove(index-1);
        minHelp.remove(index-1);
        index--;
        // System.out.println("-pop "+val);
    }

    public int top() {
        if(stk.isEmpty()) return -1;
        int val =  stk.get(index-1);
        //  System.out.println("--top --"+val);
        return val;
    }

    public int getMin() {
        if(index==0) return -1;
        return minHelp.get(index-1);
    }

}
