import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class convertStr {

    public static char getParent(char val, int[] parent) {
        int intval = val - 'a';
        while(parent[intval]!=intval) {
            intval = parent[intval];
        }
        return (char)(intval + 'a');
    }

    public static void join(char val1 , char val2, int[] parent) {
        int intval = val1 - 'a';
        int intval2 = val2 - 'a';
        parent[intval] = intval2;
    }

    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int t = scanner.nextInt();

        while(t>0) {
            int[] parent = new int[27];
            for(int i=0;i<27;i++) {
                parent[i] = i;
            }
            String str = scanner1.nextLine();
            int n = scanner.nextInt();
            while(n>0) {
                char a = scanner.next().charAt(0);
                char b = scanner.next().charAt(0);

                char para = getParent(a, parent);
                char parb = getParent(b, parent);

                join(para, parb, parent);
                n--;
            }
            Set<Character> set = new HashSet<>();
            for(int i=0;i<str.length();i++) {
                char s = getParent(str.charAt(i) , parent);
                set.add(s);
            }
            if(set.size()==1) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
            t--;

        }
    }
}