
public class RatInMaze {

    public static boolean isPossible(int i,int j, int n) {
        if(i<0 || j<0 || i>n-1 || j>n-1)
            return false;
        return true;
    }


    public static int solve(int[][] maze ,int rowIndex, int colIndex,  int n , int [][] memo, boolean[][] visited) {

        if(!isPossible(rowIndex, colIndex , n)) {
            return 0;
        }

//        if(memo[rowIndex][colIndex]!=-1)
//            return memo[rowIndex][colIndex];

        if(visited[rowIndex][colIndex])  {
            return 0;
        }

        if(maze[rowIndex][colIndex]==0)
            return 0;

        if(rowIndex==n-1 && colIndex == n-1) {
            return 1;
        }
        visited[rowIndex][colIndex] = true;



        int top = solve(maze , rowIndex - 1 , colIndex , n, memo,visited);
        int left = solve(maze , rowIndex , colIndex-1 , n, memo, visited);
        int right = solve(maze , rowIndex  , colIndex+1 , n, memo,visited);
        int down = solve(maze , rowIndex + 1 , colIndex , n, memo,visited);


        int waysFromThisNode =  left + top + right + down;
        memo[rowIndex][colIndex] = waysFromThisNode;
        visited[rowIndex][colIndex] = false;

        return waysFromThisNode;
    }


    public  static void main(String [] args) {
        int n = 5;
        int [][] maze = {{ 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1 } };

        int [][] memo = new int[n][n];
        boolean [][] visited = new boolean[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                memo[i][j] = -1;
                visited[i][j]=false;
            }
        }

       int ans =  solve(maze , 0, 0, n, memo, visited);
        System.out.println(ans);
    }
}
