/*
BFS, 队列辅助，第一次独立写出来的bfs，但是两周没写bfs类型的又生疏了
下面还有DFS递归版本，注意count在每次递归调用后都是重置为0的
*/

class Solution {
    int[] dirX = new int[] {0, 0, 1, 1, 1, -1, -1, -1};
    int[] dirY = new int[] {-1, 1, -1, 0, 1,-1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        if(board[i][j] == 'M') board[i][j] = 'X';
        else{
            check(board, click);
        }
        return board;
    }

    public void check(char[][] board, int[] click){
        Queue<int[]> q = new LinkedList<>();
        q.offer(click);
        boolean[][] vis = new boolean[board.length][board[0].length];
        vis[click[0]][click[1]] = true;
        while(!q.isEmpty()){
            int count = 0;
            int row = q.peek()[0];
            int col = q.poll()[1];
           
            for(int i = 0; i < 8; i++){
                int newR = row + dirX[i];
                int newC = col + dirY[i];
                if(newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length){
                    if(board[newR][newC] == 'M') count ++;
                }    
            }
            if(count != 0){
                board[row][col] = (char)(count + '0');
            }else{
                board[row][col] = 'B';
                for(int i = 0; i < 8; i++){
                    int newR = row + dirX[i];
                    int newC = col + dirY[i];
                    if(newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length && !vis[newR][newC]){
                        q.offer(new int[]{newR, newC});
                        vis[newR][newC] = true;
                    }
                }
            }
        }
    }
}
//DFS,递归版本
class Solution{
    int[] dirX = new int[] {0, 0, 1, 1, 1, -1, -1, -1};
    int[] dirY = new int[] {-1, 1, -1, 0, 1,-1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click){
        int x = click[0];
        int y = click[1];
        if(board[x][y] == 'M') board[x][y] = 'X';
        else{
            dfs(board, click);
        }
        return board;
    }

    public void dfs(char[][] board, int[] click){
        int x = click[0];
        int y = click[1];
        int count = 0;
        for(int i = 0; i < 8; i ++){
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                if(board[newX][newY] == 'M') count++;
            }
        }
        if(count != 0) board[x][y] = (char)(count+'0');
        else{
            board[x][y] = 'B';
            for(int i = 0; i < 8; i ++){
                int newX = x + dirX[i];
                int newY = y + dirY[i];
                if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                    if(board[newX][newY] == 'E') {
                        dfs(board, new int[]{newX, newY});
                    }
                }
            }
        }

    }
}
