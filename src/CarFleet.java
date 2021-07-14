//https://leetcode.com/problems/car-fleet/
import java.util.*;

public class CarFleet {

    class CarPos implements Comparable<CarPos>{
        Integer pos;
        Float timeReq;
        public CarPos(int a,float b) {
           pos = a;
           timeReq = b;
        }

        @Override
        public int compareTo(CarPos o) {
            int val =  o.pos.compareTo(this.pos);
            if(val!=0) return val;
            return this.timeReq.compareTo(o.timeReq);
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<CarPos> list = new ArrayList<>();
        float[] timeRew = new float[n];
        for(int i=0;i<n;i++) {
            int diffLeft =  target - position[i];
            float timeReq = ((float)diffLeft/speed[i]);
            CarPos carPos = new CarPos(position[i] , timeReq);
            list.add(carPos);
        }
        Collections.sort(list);
        for(int i=0;i<n;i++) {
            timeRew[i] =  list.get(i).timeReq;
        }

        Stack<Integer> stc = new Stack<>();

        int[] nextHigher = new int[n];

        for(int i=n-1;i>=0;i--) {
            float val = timeRew[i];
            if(stc.isEmpty()) {
                stc.push(i);
            }
            else {
                while(timeRew[stc.peek()] <= val) {
                    int popVal = stc.pop();
                    if(stc.isEmpty()) break;
                }
                stc.push(i);
            }

        }


        return stc.size();
    }


    public static void main(String[] args)
    {
        int[] a = {8,3,7,4,6,5};
        int[] b= {4,4,4,4,4,4};
        CarFleet timeToUpdate = new CarFleet();
        int ans = timeToUpdate.carFleet(10,a,b);
        int x = ans;

    }
}
