import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeForcesNew {

    public static void main(String []  args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int t = myObj.nextInt();
        while(t!=0) {
            int n = myObj.nextInt();
            // System.out.print(n + " ");
            //int [] arr = new int[n];
            int oddCount = 0;
            int evenCount = 0;
            for(int i=0;i<2*n;i++) {
                int val = myObj.nextInt();
                if(val%2==0)
                    evenCount++;
                else
                    oddCount++;
                //arr[i] = val;
            }
            if(evenCount==oddCount) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }

            t--;
        }
    }
}


 class CodeForcesSec {
    public static void main(String []  args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int t = myObj.nextInt();
        while(t!=0) {
            int n = myObj.nextInt();
            int a = myObj.nextInt();
            int b = myObj.nextInt();
            double val = (double)(n-1)/b;
            if(val==Math.ceil(val)) {
                System.out.println("Yes");
            }
            else {
                double val1 = Math.log(n);
                double val2 = Math.log(a);

                double qu = val1/val2;

                if(qu==Math.ceil(qu)) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
            }
            t--;
        }
    }
}
