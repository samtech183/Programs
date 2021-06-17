import java.util.ArrayList;
import java.util.List;

public class RegionIntwoDmatrix {
    int[][] arr = {{1,0} , {-1,0} , {0,1} , {0,-1}, {-1,-1} , {-1,1}, {1,1} , {1,-1}};

    boolean isPossible(int i , int j ,ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        if(i<0 || i>n-1 || j<0 || j>m-1) {
            return false;
        }
        return true;
    }

    int rec(int row , int col, ArrayList<ArrayList<Integer>> A , boolean[][] visited) {
        if(visited[row][col]) {
            return 0;
        }

        if(A.get(row).get(col)==0)
            return 0;

        visited[row][col]=true;
        int ans = 1;
        for(int i=0;i<arr.length;i++) {
            int newRow =  row + arr[i][0];
            int newCol =  col + arr[i][1];
            if(isPossible(newRow , newCol , A)) {
                ans  += rec(newRow , newCol , A,visited);
            }
        }

        return ans;

    }


    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) visited[i][j]=false;

        int ans = 0;
        for(int i=0;i<n;i++)  {
            for(int j=0;j<m;j++) {
                if(A.get(i).get(j)==1) {
                   ans = Math.max(ans,rec(i,j,A,visited));
                }
            }
        }
        return ans;
    }

    public static  void main(String[] args) {
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        int n = 4;
        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);
        row.add(0);
        row.add(1);
        row.add(1);
        row.add(0);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(1);
        row2.add(1);
        row2.add(1);
        row2.add(0);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(0);
        row3.add(0);
        row3.add(0);
        row3.add(0);

        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(0);
        row4.add(0);
        row4.add(0);
        row4.add(0);
        row4.add(1);

        test.add(row);
        test.add(row2);
        test.add(row3);
        test.add(row4);

        RegionIntwoDmatrix regionIntwoDmatrix =  new RegionIntwoDmatrix();
        regionIntwoDmatrix.solve(test);

    }


}
