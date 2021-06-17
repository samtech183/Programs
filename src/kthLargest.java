import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class kthLargest {

    List<List<Integer>> snapshots = new ArrayList<>();
    List<Integer> lst;
    Map<Integer , TreeMap<Integer , Integer>> map = new HashMap<>();
    int snapNo = 0;

    public kthLargest(int length) {
        for(int i=0;i<length;i++) {
            map.put(i , new TreeMap<>());
        }
    }

    public void set(int index, int val) {
        map.get(index).put(snapNo , val);
    }

    public int snap() {
        snapNo++;
        return snapNo-1;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer , Integer> mp = map.get(index);
        if(mp.containsKey(snap_id)) {
            return mp.get(snap_id);
        }
        if(mp.isEmpty()) {
            return 0;
        }

       return mp.get(mp.lastKey());
    }

//    static class Pair {
//        int start;
//        int end;
//        Pair(int a,int b) {
//            start = a;
//            end = b;
//        }
//    }
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int start = lower;
        int end = start;
        List<String> pairs = new ArrayList<>();
        int n = nums.length;
        if(n==0) {
            if(start==end) {
                pairs.add(String.valueOf(start));
            }
            else {
                pairs.add(String.valueOf(start).concat("->").concat(String.valueOf(upper)));
            }
            return pairs;
        }
        for(int i=0;i<n;i++) {
            int val = nums[i];
            if(val>start) {
                end = val-1;
                if(start==end) {
                    pairs.add(String.valueOf(start));
                }
                else {
                    pairs.add(String.valueOf(start).concat("->").concat(String.valueOf(end)));
                }
                //pairs.add(new Pair(start , end));
            }
            start = val+1;
        }
        if(end!=upper && start<=upper) {
            end = upper;
            if(start==end) {
                pairs.add(String.valueOf(start));
            }
            else {
                pairs.add(String.valueOf(start).concat("->").concat(String.valueOf(end)));
            }
        }
        return pairs;
    }



    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> lst = new ArrayList<>(10);
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        //HashMap<Integer, Boolean> check = new HashMap<>();

        int n = nums.length;

        for(int i=0;i<n;i++) {
            int val = nums[i];
//            if(check.containsKey(val)) {
//                continue;
//            }
//            check.putIfAbsent(val,true);
            if(st1.isEmpty()) {
                st1.push(val);
            }
            else {
                while(!st1.isEmpty() && st1.peek()>val) {
                    st2.push(st1.pop());
                }
                st1.push(val);

                while(!st2.isEmpty()) {
                    st1.push(st2.pop());
                }
            }
        }
        int ans = -1;
        while(k>0) {
            ans = st1.pop();
            k--;
        }
        return ans;
    }

    public  static void main(String[] args)  {
//        kthLargest kthLargest = new kthLargest(4);
//        int id = kthLargest.snap();
//        int val1  = kthLargest.get(1,0);
//        int val2  = kthLargest.get(0,0);
//
//        kthLargest.set(1,8);
//
//        kthLargest.set(0,10);
//       int val  = kthLargest.get(0,0);

        int[] input = new int[0];


        findMissingRanges(input, 1, 1);

//        kthLargest kt = new kthLargest();
//        int ans =  kt.findKthLargest(input,2);

    }
}
