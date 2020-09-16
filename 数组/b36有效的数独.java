/*
关键在于如何确定boxindex
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j ++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    rows[i][num]++;
                    cols[j][num]++;
                    int boxIndex = 3*(i/3) + j/3;
                    boxes[boxIndex][num]++;
                    if(rows[i][num] > 1 || cols[j][num] > 1 || boxes[boxIndex][num] > 1) return false;
                }
            }
        } 
        return true;
    }
}
