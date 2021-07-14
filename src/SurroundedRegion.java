import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegion {

    class Pr {
        int row;
        int col;
        Pr(int r,int c) {
            row = r;
            col = c;
        }
    }
    public  boolean canStart(int row,int col, char[][] board) {
        if((row-1)>=0 && board[row-1][col]=='X') {
          return true;
        }
        if((row+1)<board.length && board[row+1][col]=='X') {
            return true;        }
        if((col-1)>=0 && board[row][col-1]=='X') {
            return true;        }
        if((col+1)<board[0].length && board[row][col+1]=='X') {
            return true;
        }
        return false;
    }

    boolean[][] vis=new boolean[5][5];
    public boolean dfs(int row , int col, char[][] board, List<Pr> visited) {
        int n = board.length;
        int m = board[0].length;
        if(row==0 || row==n-1 || col==0 || col==m-1) {
            return false;
        }
        if(vis[row][col]) {
            return true;
        }
        visited.add(new Pr(row , col));
        vis[row][col]=true;

        boolean resp = true;
        if(board[row-1][col]=='0') {
           resp =   dfs(row-1,col,board,visited) && resp;
        }
        if(board[row+1][col]=='0') {
            resp = dfs(row+1,col,board,visited) && resp;
        }
        if(board[row][col-1]=='0') {
            resp = dfs(row,col-1,board,visited) && resp;
        }
        if(board[row][col+1]=='0') {
            resp = dfs(row,col+1,board,visited) && resp;
        }
        return resp;
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(board[i][j]=='0' && canStart(i,j,board)) {
                    List<Pr> changed = new ArrayList<>();
                    boolean resp = dfs(i,j,board,changed);
                    if(resp) {
                        for(Pr pair : changed) {
                            board[pair.row][pair.col] = 'X';
                        }
                    }

                }
            }
        }
    }

    public static void main(String args[])
    {
        char[][] innput = {
                {'X','0','X','X'}
                ,{'X','0','0','0'}
                ,{'X','0','0','X'}
                ,{'X','0','X','X'}};

        SurroundedRegion SR = new SurroundedRegion();
        SR.solve(innput);

    }

}
