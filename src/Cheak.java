import java.util.*;
import java.util.stream.Collectors;

class Solution
{


    static void swap(String str , int a,int b) {

    }

    public static String nextPalin(String str)
    {
        int n = str.length();
        List<Character> lst = new ArrayList<>();

        Stack<Integer> stack  = new Stack<>();

        char last = str.charAt(n/2-1);

        StringBuilder ans = new StringBuilder();
        ans.append(last);

        for(int i=n/2-2;i>=0;i--) {
            if(str.charAt(i) < last) {
                for(int j=n/2-1;j>=0;j--) {
                    if(str.charAt(j) > str.charAt(i)) {
                        swap(str , i , j);
                        break;
                    }
                }
                break;
            }
        }



//        Collections.sort(lst , Comparator.reverseOrder());
//
//        String ans = "";
//        for(int i=0;i<lst.size();i++) {
//           //System.out.println(lst.get(i));
//           ans = ans.concat(lst.get(i).toString());
//        }
//
//        if(n%2==1) {
//          ans =  ans.concat(String.valueOf(str.charAt(n/2)));
//        }
//
//        for(int i=lst.size()-1;i>=0;i--) {
//            ans = ans.concat(lst.get(i).toString());
//        }
//
//        if(ans.equals(str))
//            return "-1";
//        //System.out.println("ans is "+ ans);
        return str;
    }

    private static void solveThis(int arr[][] , int n) {
        int dp[][] = new int[n][n];;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 && j==0) {
                    dp[i][j] =  arr[i][j];
                }
                else if(i==0) {
                    dp[i][j] = dp[i][j-1] + arr[i][j];
                }
                else if(j==0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("----");
        }
    }
    public static void main(String [] args) {
//        int arr[][] =
//                { {2,3,4,5},
//                  {2,4,7,9},
//                  {5,8,11,19},
//                  {9,13,14,15}
//        };
//        solveThis(arr , 4);
        nextPalin("53435");
    }
}