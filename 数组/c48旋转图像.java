/*第三遍写，一次顺利通过
两种方法：
1旋转角落的四个矩阵.注意四个角矩阵的范围
2先转置再行翻转，【注意】转置和翻转的写法
变形，逆时针转90
*/
//四角旋转法
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return;
        for(int i = 0; i < n/2; i ++){
            for(int j = 0; j < (n+1)/2; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}
//逆时针旋转
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return;
        for(int i = 0; i < n/2; i ++){
            for(int j = 0; j < (n+1)/2; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][n-i-1];
                matrix[j][n-i-1] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[n-j-1][i];
                matrix[n-j-1][i] = tmp;
            }
        }
    }
}
//转置后翻转
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //转置
        for(int i = 0; i < n; i ++){
            for(int j = i ; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //翻转
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n/2; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;  
            }
        }
    }
}
