

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class HotelBooking {
    HashMap<Integer, Node>  check = new HashMap<>();
     static class Booking implements Comparable<Booking>{
        Integer departure;
        Integer arrival;

         @Override
         public int compareTo(Booking o) {
             return this.departure.compareTo(o.departure);
         }
     }
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
         int n = arrive.size();
         List<Booking> bookings = new ArrayList<>();
         for(int i=0;i<n;i++) {
             if(depart.get(i).equals(arrive.get(i))) continue;
             Booking booking = new Booking();
             booking.departure = depart.get(i);
             booking.arrival = arrive.get(i);
             bookings.add(booking);
         }
        Collections.sort(bookings);
         n  = bookings.size();
         int maxRooms = 0;
         for(int i=0;i<n;i++) {
             Booking booking = bookings.get(i);
             int val = booking.departure;
             int count = 1;
             for(int j=i+1;j<n;j++) {
                 if(bookings.get(j).arrival < val) {
                     count++;
                 }
             }
             if(count > maxRooms) {
                 maxRooms = count;
             }
         }
         if(maxRooms > K) {
             return false;
         }
         return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrival = new ArrayList<>();
        ArrayList<Integer> dep = new ArrayList<>();
         arrival.add(40);
         arrival.add(40);
        arrival.add(41);
        arrival.add(43);
        arrival.add(46);
        arrival.add(47);

       List<Integer> s =   arrival.subList(0,2);

         dep.add(10);
         dep.add(43);

         HotelBooking hotelBooking = new HotelBooking();

         hotelBooking.check.put(1 , new Node(100));
          Node node = hotelBooking.check.get(1);
          node.lst.add(10);
         node.lst.add(20);

         hotelBooking.hotel(arrival , dep , 2);

    }
}
