/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (grid[source.x][source.y] || grid[destination.x][destination.y]) {
            return -1;
        }
        
        int[] directX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] directY = {2, -2, 2, -2, 1, -1, 1, -1};
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(source);
        
        int path = 0;
        if (source.x == destination.x && source.y == destination.y) {
            return path;
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int j = 0; j < 8; j++) {
                    Point next = new Point(point.x + directX[j], point.y + directY[j]);
                    if (!inBound(next, grid)) {
                        continue;
                    }
                    if (next.x == destination.x && next.y == destination.y) {
                        return path;
                    }
                    grid[next.x][next.y] = true;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
    
    private boolean inBound(Point next, boolean[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        if (next.x < 0 || next.x >= row) {
            return false;
        }
        if (next.y < 0 || next.y >= col) {
            return false;
        }
        return !grid[next.x][next.y];
    }
}