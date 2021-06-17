import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Meeting {
    class pair implements Comparable<pair> {
        Integer val;
        boolean isLeaving;
        pair(int val , Boolean isLeave) {
            this.val = val;
            this.isLeaving = isLeave;
        }

        @Override
        public int compareTo(pair o) {
            int val =  this.val.compareTo(o.val);
            if(val!=0) return val;
            if(!this.isLeaving) return 1;
            return -1;
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {

        List<pair> val = new ArrayList<>();
        int n = A.size();
        for(int i=0;i<n;i++) {
            val.add(new pair(A.get(i).get(0),  false) );
            val.add(new pair(A.get(i).get(1),  true) );
        }
        Collections.sort(val);
        int count = 0;
        int maxi = 0;
        for(int i=0;i<val.size();i++) {
            if(val.get(i).isLeaving) {
                count--;
            }
            else {
                count++;
            }
            maxi = Math.max(count , maxi);
        }

        return maxi;
    }

    public  static  void main(String [] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList b1 = new ArrayList();
        b1.add(17);
        b1.add(26);

        ArrayList b2 = new ArrayList();
        b2.add(14);
        b2.add(22);

        ArrayList b3 = new ArrayList();
        b3.add(7);
        b3.add(29);

        ArrayList b4 = new ArrayList();
        b4.add(2);
        b4.add(29);

        ArrayList b5 = new ArrayList();
        b5.add(11);
        b5.add(14);

        ArrayList b6 = new ArrayList();
        b6.add(5);
        b6.add(24);

        ArrayList b7 = new ArrayList();
        b7.add(1);
        b7.add(14);

        ArrayList b8 = new ArrayList();
        b8.add(13);
        b8.add(14);


        A.add(b1);
        A.add(b2);
        A.add(b3);
        A.add(b4);
        A.add(b5);
        A.add(b6);
        A.add(b7);
        A.add(b8);
        Meeting meeting = new Meeting();
        meeting.solve(A);


    }

}
