public class MinHeightPath {


    int[][] dp = new int[101][101];
    boolean[][] vis = new boolean[101][101];

    boolean checkIfCanMove(int row,int col, int n,int m) {
        if(row<0 || row>n-1 || col<0 || col>m-1) return false;
        return true;
    }

    int rec(int i, int j, int[][] heights, int currAbs) {
        int n = heights.length;
        int m = heights[0].length;


        if(vis[i][j]){
            return Integer.MAX_VALUE;
        }
        if(i==n-1 && j==m-1) {
            return currAbs;
        }
        vis[i][j] = true;

        int miniAbs = Integer.MAX_VALUE;
        if(checkIfCanMove(i+1,j,n,m) ) {
            int absDIff = Math.abs(heights[i+1][j] - heights[i][j]);
            int val = rec(i+1,j,heights,Math.max(currAbs , absDIff));
            miniAbs = Math.min(val , miniAbs);

        }

        if(checkIfCanMove(i,j+1,n,m)) {
            int absDIff = Math.abs(heights[i][j+1] - heights[i][j]);
            int val = rec(i,j+1,heights,Math.max(currAbs , absDIff));
            miniAbs = Math.min(val , miniAbs);

        }


        if(checkIfCanMove(i-1,j,n,m)) {
            int absDIff = Math.abs(heights[i-1][j] - heights[i][j]);
            int val = rec(i-1,j,heights,Math.max(currAbs , absDIff));
            miniAbs = Math.min(val , miniAbs);

        }

        if(checkIfCanMove(i,j-1,n,m)) {
            int absDIff = Math.abs(heights[i][j-1] - heights[i][j]);
            int val = rec(i,j-1,heights,Math.max(currAbs , absDIff));
            miniAbs = Math.min(val , miniAbs);

        }
        vis[i][j] = false;
        return miniAbs;
    }

    public int minimumEffortPath(int[][] heights) {
        for(int i=0;i<101;i++) {
            for(int j=0;j<101;j++) {
                dp[i][j] = -1;
            }
        }
        int ans = rec(0,0,heights,0);
        return ans;
    }

    public static void main(String[] args) {
        int[][] input = new int[3][3];
        input[0][0] = 1;
        input[0][1] = 2;
        input[0][2] = 3;


        input[1][0] = 3;
        input[1][1] = 8;
        input[1][2] = 4;

        input[2][0] = 5;
        input[2][1] = 3;
        input[2][2] = 5;


        MinHeightPath mini = new MinHeightPath();
        mini.minimumEffortPath(input);

    }
}
