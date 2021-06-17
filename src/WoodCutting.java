import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WoodCutting {

     static int getVal(ArrayList<Integer> A, int val) {
        int sum = 0;
        for(int i=0;i<A.size();i++) {
            if(A.get(i) > val) {
                sum += (A.get(i) - val);
            }
        }
        return sum;
    }


    public static int solve(ArrayList<ArrayList<Integer>> arr) {
         int n = arr.size();
         int m = arr.get(0).size();

         if(n==1) {
             for(int j=0;j<m;j++) {
                 if(arr.get(0).get(j)==1) {
                     return 1;
                 }
             }
             return 0;
         }
         if(m==1) {
             for(int j=0;j<n;j++) {
                 if(arr.get(j).get(0)==1) {
                     return 1;
                 }
             }
             return 0;

         }
         int ans = 0;
         for(int i=1;i<n;i++) {
             for(int j=1;j<m;j++) {
                 if(arr.get(i).get(j)==1) {
                     int mini = Math.min(arr.get(i-1).get(j) , arr.get(i).get(j-1));
                     mini = Math.min(mini , arr.get(i-1).get(j-1)) + 1;
                     arr.get(i).set(j,  mini);
                     ans = Math.max(ans , mini*mini);
                 }
             }
         }

//        for(int i=1;i<n;i++) {
//            for (int j = 1; j < m; j++) {
//                System.out.print(arr.get(i).get(j));
//            }
//            System.out.println("--");
//        }
        return ans;
        }




    public static  ArrayList<Integer> searchRange(final List<Integer> A, int B) {

         ArrayList<Integer> ans  = new ArrayList<>();

         int start = 0;
         int end = A.size()-1;
         while(start <= end) {
            int mid = (start + end)/ 2;
            if(A.get(mid) < B) {
                start = mid+1;
            }
            else {
                end = mid - 1;
            }
        }
         if(A.get(start)!=B) {
             ans.add(-1);
             ans.add(-1);
             return  ans;
         }
        ans.add(start);





         start = 0;
         end = A.size()-1;

        while(start <= end) {
            int mid = (start + end)/ 2;
            if(A.get(mid) <= B) {
                start = mid+1;
            }
            else {
                end = mid - 1;
            }
        }

        ans.add(end);


        return ans;

    }




    public static int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int start = 0;
        int end = A.get(A.size()-1);
        int closest = 0;
        while (start <= end){
            int check = (start + end) / 2;
            int val = getVal(A , check);
            if(val < B) {
               end = check-1;
            }
            else {
                closest = Math.max(closest , check);
                start = check+1;
            }
        }
        return closest;
    }


    static class comareClass implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }

    public static void main(String [] args) {
        ArrayList<ArrayList<Integer>> twoD = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
//        values.add(114);
//        values.add(55);
//        values.add(95);
//        values.add(131);
//        values.add(77);
//        values.add(111);
//        values.add(141);


//        values.add(5);
//        values.add(5);
//        values.add(7);
//        values.add(8);
//        values.add(8);
//        values.add(8);
//        values.add(10);

        values.add(0);
        values.add(3);
        values.add(1);
        values.add(10);
        values.add(4);

       values.sort(new comareClass());

        ArrayList<Integer> values1 = new ArrayList<>();
        values1.add(0);
        values1.add(1);
        values1.add(1);
        values1.add(1);
        values1.add(1);

        ArrayList<Integer> values2 = new ArrayList<>();
        values2.add(0);
        values2.add(1);
        values2.add(1);
        values2.add(1);
        values2.add(0);

        ArrayList<Integer> values3 = new ArrayList<>();
        values3.add(0);
        values3.add(1);
        values3.add(1);
        values3.add(1);
        values3.add(0);

        twoD.add(values);
        twoD.add(values1);
        twoD.add(values2);
        twoD.add(values3);


        solve(twoD);

      //  searchRange(values , 8);

//       int ans =  solve(values, 95);
  //      System.out.println(ans);
    }
}

