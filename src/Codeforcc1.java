import java.util.Scanner;

public class Codeforcc1 {

    public static void main(String []  args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int t = myObj.nextInt();
        while(t!=0) {
            int n = myObj.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n;i++) {
                int val = myObj.nextInt();
                arr[i] = val;
            }

            int same = 0;
            for(int i=0;i<n;i++) {
                if(arr[i]==i+1) same++;
            }
            if(same==n) {
                System.out.println(0);
                t--;
                continue;
            }
            if(arr[0]==n && arr[n-1]==1) {
                System.out.println(3);
                t--;
                continue;
            }

            if(arr[0]!=1 && arr[n-1]!=n) {
                System.out.println(2);
                t--;
                continue;
            }

            System.out.println(1);
            t--;

//           9 1 7 6 5 4 3 2 8
//
//           9 1 2 3 4 5 6 7 8
//           1 2 3 4 5 6 7 9 8
//           1 2 3 4 5 6 7 8 9

        }
    }
}
