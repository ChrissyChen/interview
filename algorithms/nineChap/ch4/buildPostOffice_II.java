class Coordinate {
    int x, y;
    public Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int EMPTY = 0;
    public int HOUSE = 1;
    public int WALL = 2;
    
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int[][] distanceSum = new int[row][col];
        int[][] visitedTimes = new int[row][col];
        
        int numHouse = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == HOUSE) {
                    numHouse++;
                    Coordinate point = new Coordinate(i, j);
                    bfs(point, grid, distanceSum, visitedTimes);
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == EMPTY && visitedTimes[i][j] == numHouse) {
                   shortest = Math.min(shortest, distanceSum[i][j]);
                }
            }
        }
        
        if (shortest != Integer.MAX_VALUE) {
            return shortest;
        } else {
            return -1;
        }
        
    }
    
    private void bfs(Coordinate point, 
                     int[][] grid, 
                     int[][] distanceSum, 
                     int[][] visitedTimes) {
        int[] directX = {1, -1, 0, 0};
        int[] directY = {0, 0, 1, -1};
        
        Queue<Coordinate> queue = new LinkedList<>();
        //Set<Coordinate> hash = new HashSet<>(); //Set自定义的class要自己重写
                        //equals()和hashcode(), 否则不能用contains().Map也一样
        boolean[][] hash = new boolean[grid.length][grid[0].length];
     
        queue.add(point);
        //hash.add(point);
        hash[point.x][point.y] = true; //mark as visited
        
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate pt = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Coordinate adj = new Coordinate(pt.x + directX[j], 
                                                    pt.y + directY[j]);
                    if (!inBound(adj, grid)) {
                        continue;
                    }
                    // if (hash.contains(adj)) {
                    //     continue;
                    // }
                    if (hash[adj.x][adj.y]) {
                        continue;
                    }
                    
                    visitedTimes[adj.x][adj.y]++;
                    distanceSum[adj.x][adj.y] += step;
                    queue.add(adj);
                    //hash.add(adj);
                    hash[adj.x][adj.y] = true;
                }
            }
        }
    }
    
    private boolean inBound(Coordinate point, int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        if (point.x < 0 || point.x >= row) {
            return false;
        }
        if (point.y < 0 || point.y >= col) {
            return false;
        }
        return (grid[point.x][point.y] == EMPTY);
    }
}