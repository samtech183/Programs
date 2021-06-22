//https://leetcode.com/problems/decode-ways/solution/
public class WaysToDecode {

    int count = 0;
    int[] memo = new int[200];

    int rec(String str, String curr, int index) {
        if(curr.length()>=1 && curr.charAt(0)=='0') {
            return 0;
        }
        boolean flag = false;
        if(curr.length()>=1) {
            flag=true;
            int val = Integer.parseInt(curr);
            if(val>26){
                return 0;
            }
        }

        int n = str.length();
        if(index==n) {
            count++;
            return 1;
        }
        int val = rec(str,curr + str.charAt(index), index+1);

        int val2=0;
        if(flag) {
            if(memo[index]!=0) {
                val2 = memo[index];
            }
            else {
                val2 = rec(str,"" + str.charAt(index),index+1);
                memo[index] = val2;
            }
        }
        return val+val2;
    }

    public int numDecodings(String s) {
       int ans =  rec(s,"",0);
        return count;
    }

    public static  void main(String[] args) {
        WaysToDecode wd = new WaysToDecode();
        wd.numDecodings("456");
    }
}
