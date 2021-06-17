import java.util.*;

public class TwodMatrix {
    static class Cell {
        int row;
        int col;
        Integer val;
        Cell(int v,int r,int c) {
            this.val = v;
            this.row = r;
            this.col = c;
        }
    }

    static class CellCompare implements Comparator<Cell> {
        public int compare(Cell s1, Cell s2) {
           return s1.val.compareTo(s2.val);
        }
    }

    public static  int kthSmallest(int[][]mat,int n,int k)
    {
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<Cell> priorityQueue = new PriorityQueue<Cell>(new CellCompare());
        Cell cell = new Cell(mat[0][0] , 0, 0);
        int count = k-1;
        priorityQueue.add(cell);
        vis[0][0]=true;
        while (!priorityQueue.isEmpty()) {
            Cell obj =priorityQueue.poll();
            if(count==0) {
                return obj.val;
            }
            int row = obj.row;
            int col = obj.col;

            int newRow = row;
            int newCol = col+1;
            if(newCol<=n-1 && ! vis[newRow][newCol]) {
                priorityQueue.add(new Cell(mat[newRow][newCol] , newRow , newCol));
                vis[newRow][newCol]=true;
            }

            newRow = row+1;
            newCol = col;
            if(newRow<=n-1 && ! vis[newRow][newCol]) {
                priorityQueue.add(new Cell(mat[newRow][newCol] , newRow , newCol));
                vis[newRow][newCol]=true;
            }
            count--;
        }
        return -1;
    }

    public static void main(String args[])
    {
       int[][] innput = {

               {7, 17, 27, 36, 38},
               {14, 23, 35, 38, 43},
               {19, 26, 42, 49, 50},
               {23, 33, 48, 52, 53},
               {30, 40, 52, 56, 64}};

       kthSmallest(innput, 5,13);
    }


}
