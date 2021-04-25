
重点：写出旋转4点的元素的索引
row,col ----------- col, n-col-1
  |                       |
  |                       |
n-col-1,row ----- n-row-1,n-col-1

同时注意枚举的子矩阵范围，如官方题解：
***..              ...**              .....              .....
***..              ...**              .....              .....
..x..   =下一项=>   ..x**   =下一项=>   ..x..   =下一项=>   **x..
.....              .....              ..***              **...
.....              .....              ..***              **...
``` java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for(int row = 0; row < n/2; row ++){
            for(int col = 0; col < (n+1)/2; col ++){
                int temp = matrix[col][n-row-1];
                matrix[col][n-row-1] = matrix[row][col];
                matrix[row][col] = matrix[n-col-1][row];
                matrix[n-col-1][row] = matrix[n-row-1][n-col-1];
                matrix[n-row-1][n-col-1] = temp;             
            }
        }
    }
}  
```
``` java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

```
