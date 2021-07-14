import java.util.LinkedList;
import java.util.Queue;

public class KnightChess {

    int[][] allPossible = {{-2,1},{-2,-1},{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

    boolean isValid(int i,int j,int A,int B) {
        if(i<=0 || i>A || j<=0 || j>B) {
            return false;
        }
        return true;
    }

    class Knit {
        int row;
        int col;
        int dist;
        Knit(int a,int b,int c) {
            row=a;
            col=b;
            dist=c;
        }
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        Queue<Knit> queue = new LinkedList<>();
        Knit knit = new Knit(C,D,0);
        queue.add(knit);

        boolean[][] visited = new boolean[A+1][B+1];
        //for(int i=0;i<=A;i++) for (int j=0;j<=B;j++) visited[i][j]=false;
       // int[] parent =

        boolean found = false;
        while (!queue.isEmpty()) {
            knit  = queue.poll();
            int row = knit.row;
            int col = knit.col;
            int dist = knit.dist;

            if(row==E && col==F) {
                found=true;
                break;
            }

            visited[row][col] = true;

            for(int i=0;i<allPossible.length;i++) {
                int[] arr =  allPossible[i];
                int newRow = row + arr[0];
                int newCol = col + arr[1];
                if(isValid(newRow , newCol , A, B) && !visited[newRow][newCol]) {
                    queue.add(new Knit(newRow,newCol,dist+1));
                }
            }
        }

        if(found) return knit.dist;

        return  -1;
    }

    public static  void main(String[] args) {
        KnightChess knightChess = new KnightChess();
        knightChess.knight(2,20,1,18,1,5);
    }
//   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
//     1 1 1 1 1 1 1 1 1 1  1  1  1  1  1  1  1  1  1  1
//     1 1 1 1 1 1 1 1 1 1  1  1  1  1  1  1  1  1  1  1
}
