import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {

    class obj {
        int node;
        int dist;
        obj(int a,int b) {
            node=a;
            dist=b;
        }
    }

    public int snakeLadder(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int[] vertices = new int[101];
        boolean[] vis = new boolean[101];
        for(int i=0;i<=100;i++) {
            vertices[i]=-1;
            vis[i]=false;
        }

        int n = A.size();
        for(int i=0;i<n;i++) {
            ArrayList<Integer> ver = A.get(i);
            vertices[ver.get(0)] = ver.get(1);
        }

        n = B.size();
        for(int i=0;i<n;i++) {
            ArrayList<Integer> ver = B.get(i);
            vertices[ver.get(0)] = ver.get(1);
        }

        Queue<obj> queue = new LinkedList<>();
        obj qe = new obj(1,0);
        queue.add(qe);


        boolean flag = false;
        while(!queue.isEmpty()) {
            qe = queue.poll();
            if(qe.node==100) {
                flag=true;
                break;
            }

            int node = qe.node;
            int dist = qe.dist;
            vis[node] = true;

            for(int i=1;i<=6;i++) {
                int conn = node + i;
                if(conn<=100) {
                    if(vertices[conn]!=-1) {
                        conn = vertices[conn];
                    }
                    if(!vis[conn]) {
                        queue.add(new obj(conn , dist+1));
                    }
                }

            }
        }

        if(flag)
            return qe.dist;

        return -1;



    }

    public static  void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        ArrayList<Integer> row = new ArrayList<>();
        row.add(32);
        row.add(62);


        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(42);
        row2.add(68);


        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(12);
        row3.add(98);


        A.add(row);
        A.add(row2);
        A.add(row3);

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        ArrayList<Integer> col1 = new ArrayList<>();
        col1.add(95);
        col1.add(14);


        ArrayList<Integer> col2 = new ArrayList<>();
        col2.add(67);
        col2.add(4);


        ArrayList<Integer> col3 = new ArrayList<>();
        col3.add(55);
        col3.add(19);

        B.add(col1);
        B.add(col2);
        B.add(col3);


        SnakeLadder snakeLadder =  new SnakeLadder();
        snakeLadder.snakeLadder(A,B);

    }



}
