import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TRappingRainWater {
    public static int trap( List<Integer> A) {
//
//        List<Integer> A = new ArrayList<>();
//        for(int i=0;i<n;i++) {
//            A.add(arr[i]);
//        }
        ArrayList<Integer> nextGreater = new ArrayList<>();
        ArrayList<Integer> nextGreaterBak = new ArrayList<>();
        for(int i=0;i<A.size();i++) {
            nextGreater.add(-1);
            nextGreaterBak.add(-1);
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<A.size();i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else {
               int top =  stack.peek();
               if(A.get(top) > A.get(i)) {
                   stack.push(i);
               }
               else {
                   while(!stack.isEmpty()) {
                       int top1 =  stack.peek();
                       if(A.get(top1) <= A.get(i)) {
                           nextGreater.set(top1 , i);
                       }
                       else {
                           break;
                       }
                       stack.pop();
                   }
                   stack.push(i);
               }
            }
        }

        while(!stack.isEmpty()) {
            stack.pop();
        }
        int n =  A.size();
        for(int i=n-1;i>=0;i--) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            else {
                int top = stack.peek();
                if(A.get(top) >= A.get(i)) {
                    stack.push(i);
                }
                else {
                    while(!stack.isEmpty()) {
                        int top1 =  stack.peek();
                        if(A.get(top1) < A.get(i)) {
                            nextGreaterBak.set(top1 , i);
                        }
                        else {
                            break;
                        }
                        stack.pop();
                    }
                    stack.push(i);
                }
            }
        }

        int index = 0;
        int ans = 0 ;
        while(index<n) {
            int nextG = nextGreater.get(index);
            if(nextG==-1) {
                break;
            }
            else {
                int sum=0;
                for(int i=index;i<=nextG;i++) {
                    sum+=Math.min(A.get(index), A.get(i));
                }
                ans += ((nextG - index + 1) * A.get(index))- sum;
                index = nextG;
            }
        }


        index = n-1;
        while(index>=0) {
            int nextG = nextGreaterBak.get(index);
            if(nextG==-1) {
                break;
            }
            else {
                int sum=0;
                for(int i=nextG;i<=index;i++) {
                    sum+=Math.min(A.get(index), A.get(i));
                }
                ans += ((index - nextG + 1) * A.get(index))- sum;
                index = nextG;
            }
        }

        return ans;
    }

    public  static  void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(6);
        test.add(1);
        test.add(8);
        test.add(9);
        test.add(2);
        test.add(7);
        test.add(9);
        test.add(5);
        test.add(4);
        test.add(3);
        trap(test);
    }
}
