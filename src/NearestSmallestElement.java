import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestElement {
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<>();
        int index = 0;
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        while(index<n) {
            int val = A.get(index);
            if(st.isEmpty()) {
                ans.add(-1);
            }
            else {
                while(!st.isEmpty()) {
                    Integer top = st.peek();
                    if(top<val) {
                        ans.add(top);
                        break;
                    }
                    else {
                        st.pop();
                    }
                }
                if(st.isEmpty()) {
                    ans.add(-1);
                }

            }
            st.push(val);
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(4);
        prevSmaller(ans);

    }
}
