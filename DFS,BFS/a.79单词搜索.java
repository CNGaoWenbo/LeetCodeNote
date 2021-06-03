class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1,-1, 0, 0};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m == 0) return false;
        int n = board[0].length;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int u){
        if(board[x][y] != word.charAt(u)) return false;
        if(u == word.length()-1) return true;
        
        board[x][y] = ' ';
        for(int i = 0; i < 4; i ++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                if(dfs(board, newX, newY, word, u+1)){
                    return true;
                } 
            }
        }
        board[x][y] = word.charAt(u);
        return false;
    }
}
