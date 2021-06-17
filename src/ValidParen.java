import java.util.Stack;

public class ValidParen {
    boolean same(char c1, char c2) {
        if(c1=='(' && c2==')') return true;
        if(c1=='[' && c2==']') return true;
        if(c1=='{' && c2=='}') return true;
        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++) {
            char val = s.charAt(i);
            if(val=='}' || val == ')' || val==']') {
                if(stk.isEmpty()) {
                    return false;
                }
                else {
                    Character c =  stk.pop();
                    if(!same(c , val)) {
                        return false;
                    }
                }
            }
            else {
                stk.push(val);
            }
        }
        return stk.isEmpty();
    }

    public  static  void main(String [] args) {
        String s = "([][]{}[]{})";
        ValidParen va = new ValidParen();
        Boolean ans =  va.isValid(s);
        System.out.println("ans "+ ans);
    }
}
