import java.util.Scanner;

public class COdeF {

    static int geMinDevisor(int n) {
        for(int i=1;i<=n;i++) {
            if(n%i!=0) return i;
        }
        return n+1;
    }

    public static void main(String []  args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int t = myObj.nextInt();
        while(t!=0) {
            long n = myObj.nextLong();
            int sum = 0;
            int[] val = new int[1080];
            for(int i=1;i<=n;i++) {
                int ss = 5 + i;
                int res = geMinDevisor(i);
                val[res]++;
                if(res>10) {
                    System.out.println("i "+i);
                }
                System.out.println("[ " + ss + " ] => " + res);
                sum+=res;
                sum = sum % 1000000007;
            }
            System.out.println(sum);
            t--;
        }
    }
}
