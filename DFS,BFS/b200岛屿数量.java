/*
BFS+队列
*/
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        if(grid.length == 0) return 0;
        int[] dirX = new int[]{0, 0, 1, -1};
        int[] dirY = new int[]{1, -1, 0, 0};
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(vis[i][j] || grid[i][j] == '0') continue;
                vis[i][j] = true;
                q.offer(new int[]{i, j});
                while(!q.isEmpty()){
                    int[] pos = q.poll();
                    int posX = pos[0];
                    int posY = pos[1];
                    for(int index = 0; index < 4; index ++){
                        int sx = posX+dirX[index];
                        int sy = posY+dirY[index];
                        if(sx < 0 || sx >= grid.length || sy < 0 || sy >= grid[0].length || vis[sx][sy] || grid[sx][sy] == '0') continue;//未访问且为陆地1
                        q.offer(new int[]{sx,sy});//四周游走
                        vis[sx][sy] = true;
                    }
                }
                count ++;             
            }
        }
        return count;
    }
}
