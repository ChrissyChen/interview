class Position {
    public int x, y, val;
    public Position(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}


public class Solution {
    private Comparator<Position> PositionComparator = new Comparator<Position>() {
        public int compare(Position a, Position b) {
            return a.val - b.val;
        }
    };
    
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        Queue<Position> minHeap = new PriorityQueue<Position>(k, PositionComparator);
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[] directionX = {0, 1};
        int[] directionY = {1, 0};
        
        minHeap.add(new Position(0, 0, matrix[0][0]));
        
        for (int i = 0; i < k - 1; i++) {
            Position current = minHeap.poll();
            for (int j = 0; j < 2; j++) {
                int nextX = current.x + directionX[j];
                int nextY = current.y + directionY[j];
                // pay attention!!! x y 位置弄反了，matrix[x][y] 中x是竖的.
                // if (nextX < matrix[0].length && nextY < matrix.length && !visited[nextX][nextY]) {
                //     Position pt = new Position(nextX, nextY, matrix[nextX][nextY]);
                //     minHeap.add(pt);
                //     visited[nextX][nextY] = true;
                // }
                
                if (nextX < matrix.length && nextY < matrix[0].length && !visited[nextX][nextY]) {
                    Position pt = new Position(nextX, nextY, matrix[nextX][nextY]);
                    minHeap.add(pt);
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        return minHeap.peek().val;
    }
}