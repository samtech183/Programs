import java.util.HashSet;
//https://leetcode.com/problems/the-maze/

public class Maze {

    boolean[][] vis = new boolean[101][101];
    boolean ans = false;

    boolean isValid(int i,int j,int n,int m) {
        if(i<0 || i>n-1 || j<0 || j>m-1) {
            return false;
        }
        return true;
    }

    int[] getNextInDirection(int i,int j,int[][] maze,String dir) {
        int[] resp = new int[2];
        int[] diff = new int[2];
        int n = maze.length;
        int m = maze[0].length;
        if(dir.equals("L")) {
            diff[0] = 0;
            diff[1] = -1;
        }
        else if(dir.equals("R")) {
            diff[0] = 0;
            diff[1] = 1;
        }
        else if(dir.equals("T")) {
            diff[0] = -1;
            diff[1] = 0;
        }
        else if(dir.equals("D")) {
            diff[0] = 1;
            diff[1] = 0;
        }

        while(maze[i][j]!=1) {
            i += diff[0];
            j += diff[1];
            if(!isValid(i,j,n,m)) {
             break;
            }
        }

        resp[0] = i-diff[0];
        resp[1] = j-diff[1];
        return resp;
    }

    boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    void rec(int[] curr , int[][] maze, int[] dest) {
        if(ans) return;
        if(vis[curr[0]][curr[1]])
            return;

        if(isSame(curr,dest)) {
            ans = true;
            return;
        }

        int row = curr[0];
        int col = curr[1];

        vis[row][col] = true;

        int[] leftResp = getNextInDirection(row,col,maze,"L");
        int[] rightResp = getNextInDirection(row,col,maze,"R");
        int[] topResp = getNextInDirection(row,col,maze,"T");
        int[] downResp = getNextInDirection(row,col,maze,"D");


        if(!isSame(leftResp,curr)) {
            rec(leftResp , maze , dest);
        }
        if(!isSame(rightResp,curr)) {
            rec(rightResp , maze , dest);
        }
        if(!isSame(topResp,curr)) {
            rec(topResp , maze , dest);
        }
        if(!isSame(downResp,curr)) {
            rec(downResp , maze , dest);
        }
    }


    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        rec(start,maze,destination);
        return ans;
    }

    public static void main(String[] args)
    {
        int graph[][] = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        Maze maze = new Maze();
        int[] a = {0,4};
        int[] b = {4,4};

        maze.hasPath(graph,a,b);

    }

}
