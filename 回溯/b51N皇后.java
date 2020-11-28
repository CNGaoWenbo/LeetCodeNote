//回溯不难，数据结构转换等实现部分难
//一开始尝试用boolean[] row，List<boolean[]> board没能实现，最后还是用了char[][] board
//char[][] -> String
//char[][] 可以修改
//for(初始；条件； 运算)的灵活使用
class Solution {
    List<List<String>> boards = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j]='.';
            }
        }//construct empty chess board
        backTrack(n, board, 0);
        return boards;
    }

    public void backTrack(int n, char[][] board, int rowN){
        if(rowN == n){
            boards.add(new ArrayList(convert(board)));
            return;
        }

        for(int i = 0; i < n; i ++){
            if(!valid(board, rowN, i)) continue;
            else{
                board[rowN][i] = 'Q';
                backTrack(n, board, rowN+1);
                board[rowN][i] = '.';
            };
        }
        return;
    }

    public List<String> convert(char[][] board){
        List<String> boardStr = new ArrayList<>();
        for(int i = 0; i < board.length; i ++){
            boardStr.add(new String(board[i]));
        }
        return boardStr;
    }
    public boolean valid(char[][] board, int row, int col){
        int len = board.length;
        //check column
        for (int i = 0; i < len; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        //check UR
        for (int i = row - 1, j = col + 1; 
                i >= 0 && j < len; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        //check UL
        for (int i = row - 1, j = col - 1;
                i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
