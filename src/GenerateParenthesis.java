import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    List<String> finalList = new ArrayList<>();

    void rec(String curr  , int openCount, int closeCount, int openCountLeft, int closeCountLeft) {
        if(openCountLeft==0 && closeCountLeft==0) {
            finalList.add(curr);
            return ;
        }
        if(openCountLeft>0) {
            rec(curr + "("   ,openCount + 1 , closeCount, openCountLeft-1, closeCountLeft);
        }
        if (closeCountLeft>0 && openCount>closeCount) {
            rec(curr + ")" ,openCount , closeCount + 1, openCountLeft, closeCountLeft-1);
        }
        return;
    }

    public List<String> generateParenthesis(int n) {
        rec("",0,0,n,n);
        return finalList;
    }

    public static  void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        gp.generateParenthesis(3);
    }

}
