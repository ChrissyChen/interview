class Coordinate {
    int x, y;
    public Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]) {
                    markBFS(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }
    
    // from (x,y) mark all connected 1 to 0
    private void markBFS(boolean[][] grid, int x, int y) {
        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};
        
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(x,y));
        grid[x][y] = false;
        
        while (!queue.isEmpty()) {
            Coordinate node = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(node.x + directionX[i], 
                                                node.y + directionY[i]);
                if (!inBound(adj, grid)) {
                    continue;
                }
                if (grid[adj.x][adj.y]) {
                    queue.add(adj);
                    grid[adj.x][adj.y] = false;
                }
            }
        }
    }
    
    private boolean inBound(Coordinate node, boolean[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        return (node.x < row && node.x >= 0 && node.y < col && node.y >= 0);
    }
}