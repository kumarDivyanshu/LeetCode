class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                firstRowZero = true;
                break;
            }
        }

        for(int j=0;j<m;j++){
            if(matrix[0][j]==0){
                firstColZero = true;
                break;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]= 0;
                    matrix[0][j]= 0;
                }
            }
        }
        
        setRowZero(n,m,matrix);
        if(firstRowZero){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
        if(firstColZero){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        return;

        

    }
    void setRowZero(int n , int m, int[][] matrix){
            for(int i=1;i<n;i++){
                if(matrix[i][0] == 0){
                    for(int j=0 ; j<m ; j++){
                        matrix[i][j]=0;
                    }
                } 
            }

            for(int j=1;j<m;j++){
                if(matrix[0][j] == 0){
                    for(int i=0 ; i<n ; i++){
                        matrix[i][j]=0;
                    }
                } 
            }
    }
}