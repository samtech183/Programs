import java.util.Stack;

public class StringComp {

    String getStrFromStack(Stack<Character> stack) {
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop().toString());
        }
        return str.toString();
    }
    public boolean backspaceCompare(String s, String t) {
       Stack<Character> st1 = new Stack<>();
       Stack<Character> st2 = new Stack<>();

       int n1 = s.length();
       for(int i=0;i<n1;i++) {
           char c = s.charAt(i);
           if(c=='#' && !st1.isEmpty()) {
               st1.pop();
           }
           else if(c!='#'){
               st1.push(c);
           }
       }

        int n2 = t.length();
        for(int i=0;i<n2;i++) {
            char c = t.charAt(i);
            if(c=='#' && !st2.isEmpty()) {
                st2.pop();
            }
            else if(c!='#') {
                st2.push(c);
            }
        }

        String str1 = getStrFromStack(st1);
        String str2 = getStrFromStack(st2);
        return str1.equals(str2);
    }


    public  static  void main(String[] args) {
        StringComp stringComp = new StringComp();
        stringComp.backspaceCompare("y#fo##f","y#f#o##f");
    }
}
