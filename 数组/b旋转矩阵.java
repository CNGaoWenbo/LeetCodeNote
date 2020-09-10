/*
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

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
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
