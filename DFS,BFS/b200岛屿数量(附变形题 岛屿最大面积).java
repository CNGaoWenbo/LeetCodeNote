/*
BFS+队列
*/
//下面是自己写的第一版BFS，可以改进的地方是vis，每次把某一个坐标加入队列后，把值置为‘0’即可，不需要再浪费一个vis[m][n]的空间
//附变形题 岛屿最大面积
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
                        vis[sx][sy] = true;//改进：grid[][] = '0';即可
                    }
                }
                count ++;             
            }
        }
        return count;
    }
}
//DFS递归写法，写的很顺利一遍过
class Solution {
    int[] dirX = new int[]{0, 0, 1, -1};
    int[] dirY = new int[]{1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == '0') continue;
                dfs(grid, i, j);
                count ++;
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') return;
        grid[x][y] = '0';
        for(int i = 0; i < 4; i ++){
            dfs(grid, x+dirX[i], y+dirY[i]);
        }
    }
}

//岛屿最大面积
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0) return 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
                    ans.add(bfs(grid, i, j));
                }
            }
        }
        if(ans.size() == 0) return 0;
        Collections.sort(ans);
        return ans.get(ans.size()-1);
    }
    
    public int bfs(int[][] grid, int x, int y){
        int count = 1;
        int[] dirX = new int[]{0, 0, 1, -1};
        int[] dirY = new int[]{1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        grid[x][y] = 0;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for(int i = 0; i < 4; i++){
                int newX = pos[0]+dirX[i];
                int newY = pos[1]+dirY[i];
                if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1){
                    q.offer(new int[]{newX, newY});
                    grid[newX][newY] = 0;
                    count ++;
                }
            }
        }
        return count;
    }
}
