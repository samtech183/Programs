//https://leetcode.com/problems/strobogrammatic-number/
public class strobogrammatic {
    public boolean isStrobogrammatic(String num) {
        StringBuilder newStr= new StringBuilder();
        int n = num.length();
        for(int i=0;i<n;i++) {
            if(num.charAt(i)=='6') {
                newStr.append('9');
            }
            else if(num.charAt(i)=='9') {
                newStr.append('6');
            }
           else if(num.charAt(i)=='1') {
                newStr.append(num.charAt(i));
            }
            else if(num.charAt(i)=='8') {
                newStr.append(num.charAt(i));
            }
            else if(num.charAt(i)=='0') {
                newStr.append(num.charAt(i));
            }
            else {
                return false;
            }
        }

        if(newStr.reverse().toString().equals(num))
            return true;

        return false;

    }

}
