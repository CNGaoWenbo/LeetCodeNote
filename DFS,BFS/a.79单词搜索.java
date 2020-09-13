/*
DFS
递归写的仍不熟练

几个暂时没想明白的问题：
为什么要传递vis给check()?
vis的变化，为什么vis最后要重新置false?
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        if(board.length == 0) return false;
        int rowLen = board.length;
        int colLen = board[0].length;
        boolean[][] vis = new boolean[rowLen][colLen];
        for(int i = 0; i < rowLen; i ++){
            for(int j = 0; j < colLen; j ++){
                if(check(board, vis, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] vis, int row, int col, String word, int k){
        int rowLen = board.length;
        int colLen = board[0].length;      
        char target = word.charAt(k);
        if(board[row][col] != target) return false;
        else if(k == word.length()-1) return true;

        int[] dirX = new int[]{0, 0, 1, -1};
        int[] dirY = new int[]{1, -1, 0, 0};

        vis[row][col] = true;
        for(int index = 0; index < 4; index ++){
            int newRow = row+dirX[index];
            int newCol = col+dirY[index];
            if(newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen && !vis[newRow][newCol]){
                if(check(board, vis, newRow, newCol, word, k+1)){
                    return true;                    
                }
            } 
        }
        vis[row][col] = false;
        return false;
    }
}
