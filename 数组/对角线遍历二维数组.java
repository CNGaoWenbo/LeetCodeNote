class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length;
        boolean upRight = true;
        int row = 0;
        int col = 0;
        int[] ans = new int[n*m];
        ans[0] = matrix[0][0];
        for(int i = 1; i < n*m; i ++){
            if(upRight){
                if(row == 0 && col != n-1){
                    ans[i] = matrix[row][++col];
                    upRight = false;
                }else if(col == n-1){
                    ans[i] = matrix[++row][col];
                    upRight = false;
                }else{
                    ans[i] = matrix[--row][++col];
                }
                
            }else{
                if(col == 0 && row != m-1){
                    ans[i] = matrix[++row][col];
                    upRight = true;
                }else if(row == m-1){
                    ans[i] = matrix[row][++col];
                    upRight = true;
                }else{
                    ans[i] = matrix[++row][--col];
                }
                
            }
        }
        return ans;
    }
}
