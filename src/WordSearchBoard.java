import java.util.ArrayList;
import java.util.List;

public class WordSearchBoard {

   static class Obj {
        int row;
        int col;
        Obj(int i,int j) {
            row = i;
            col = j;
        }
    }

   static boolean isValid(int n,int m, int i,int j) {
        if(i<0 || i>n-1 || j<0 || j>m-1)
            return false;
        return true;
    }

    static List<Obj> getChar(ArrayList<String> A , char val) {

        List<Obj> list = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            String str = A.get(i);
            for(int j=0;j<str.length();j++) {
                if(str.charAt(j)==val) {
                    list.add(new Obj(i,j));
                }
            }
        }
        return list;
    }

    static boolean rec(ArrayList<String> A , int r, int c , int index,  String B) {
       if(index==B.length()-1) {
           return true;
       }
        int toSearch = B.charAt(index);
        int n = A.size();
        int m = A.get(0).length();

        boolean resp = false;

        if(isValid(n,m,r+1,c) && A.get(r+1).charAt(c)==toSearch) {
            resp = resp || rec(A,r+1,c,index+1,B);
        }
         if(isValid(n,m,r-1,c) && A.get(r-1).charAt(c)==toSearch) {
            resp = resp ||   rec(A,r-1,c,index+1,B);
        }
         if(isValid(n,m,r,c-1) && A.get(r).charAt(c-1)==toSearch) {
            resp = resp || rec(A,r,c-1,index+1,B);
        }
         if(isValid(n,m,r,c+1) && A.get(r).charAt(c+1)==toSearch) {
            resp = resp || rec(A,r,c+1,index+1,B);
        }

        return resp;
    }


    public static int exist(ArrayList<String> A, String B) {

        int n = A.size();
        int m = A.get(0).length();

        List<Obj> list = getChar(A,B.charAt(0));

        for(Obj obj : list) {
            int r = obj.row;
            int c = obj.col;

            int index = 1;

            boolean ss = rec(A,r,c,index,B);
            if(ss) return 1;

//            while(index<=B.length()-1) {
//
//                char toSearch = B.charAt(index);
//
//                if(isValid(n,m,r+1,c) && A.get(r+1).charAt(c)==toSearch) {
//                    r = r+1;
//                    index++;
//                }
//                else if(isValid(n,m,r-1,c) && A.get(r-1).charAt(c)==toSearch) {
//                    r = r-1;
//                    index++;
//                }
//                else if(isValid(n,m,r,c-1) && A.get(r).charAt(c-1)==toSearch) {
//                    c = c-1;
//                    index++;
//                }
//                else if(isValid(n,m,r,c+1) && A.get(r).charAt(c+1)==toSearch) {
//                    c = c+1;
//                    index++;
//                }
//                else {
//                    break;
//                }
//
//            }
//            if(index==B.length()) return 1;

        }

        return 0;
    }

    public static  void main(String[] args) {
       ArrayList<String> vals = new ArrayList<>();
       vals.add("ABCE");
       vals.add("SFCS");
       vals.add("ADEE");
       int xx =  exist(vals, "ABCCED");
       System.out.println("xx "+  xx);
    }
}
