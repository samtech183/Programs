public class RotateMatrix {

    class matCell {
        int row;
        int col;
        public matCell(int a,int b) {
            row = a;
            col = b;
        }
    }

    public matCell getNext(int row,int col, int n,int m, int jump) {
        int newRow=row;
        int newCol=col;
        m--;
        n--;

        if(row==0) {
            int moveCol = m-col;
            int moveRow = jump - moveCol;

            newRow += moveRow;
            newCol += moveCol;
        }

        else if(row==n) {
            int moveCol = col;
            int moveRow = jump - moveCol;

            newRow -= moveRow;
            newCol -= moveCol;
        }

        else if(col==n) {
            int moveRow = m-row;
            int moveCol = jump - moveRow;

            newRow += moveRow;
            newCol -= moveCol;
        }

        else if(col==0) {
            int moveRow = row;
            int moveCol = jump - moveRow;

            newRow -= moveRow;
            newCol += moveCol;
        }

        return new matCell(newRow,newCol);
    }

    public void rec(int[][] matrix , int skip) {
        int n = matrix.length - 2*skip;
        int m = matrix[0].length - 2*skip;
        int jump = m-1;


        int sr = 0;
        int sc = 0;

        System.out.println("------------------");
        int count = n*m;
        for(int i=0;i<m-1;i++) {
            System.out.println("+++++++++++++++");
            sc += 1;
            int row = sr;
            int col = sc;
            int temp =  matrix[row + skip][col+skip];
            while(true) {
                matCell mat = getNext(row,col,n,m,jump);
                System.out.println("old [" + mat.row + ":" + mat.col + "]");
                System.out.println("val new " + temp);
                int save = matrix[mat.row+skip][mat.col+skip];
                matrix[mat.row+skip][mat.col+skip] = temp;
                temp=save;
                row=mat.row;
                col=mat.col;


                if(row==sr && col==sc) {
                    break;
                }
            }
        }
    }

    public void rotate(int[][] matrix) {
        int mid = matrix.length/2;
        for(int i=0;i<mid;i++) {
            rec(matrix,i);
        }
    }

    public static  void main(String[] args) {
        int [][] matrix = {{5,1,9,11}, {2,4,8,10} , {13,3,6,7} , {15,14,12,16}};
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotate(matrix);
        System.out.println("a");
    }

}
