class Coordinate {
	int x, y;
	public Coordinate (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	public int PEOPLE = 0;
	public int ZOMBIE = 1;
	public int WALL = 2;
	
	public int[] directionX = {1, -1, 0, 0};
	public int[] directionY = {0, 0, 1, -1};

	/**
     * @param grid a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        
        // initialize the queue & count people
        int people = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (grid[i][j] == PEOPLE) {
        			people++;
        		} else if (grid[i][j] == ZOMBIE) {
        			queue.add(new Coordinate(i, j));
        		}
        	}
        }

        // corner case
        if (people == 0) {
            return 0;
        }
        
        // bfs
        int days = 0;
        while (!queue.isEmpty()) {
        	days++;
        	int size = queue.size();
        	for (int k = 0; k < size; k++) {
        		Coordinate node = queue.poll();
        		for (int i = 0; i < 4; i++) {
        			Coordinate adj = new Coordinate(node.x + directionX[i], node.y + directionY[i]);
        			if (!isPeople(adj, grid)) {
        				continue;
        			}

        			grid[adj.x][adj.y] == ZOMBIE;
        			people--;
        			if (people == 0) {
        				return days;
        			}
        			queue.add(adj);
        		}
        	}
        }
        return -1;
    }

    private boolean isPeople(Coordinate node, int[][] grid) {
    	int row = grid.length;
    	int col = grid[0].length;

    	if (node.x >= row || node.y < 0) {
    		return false;
    	}

    	if (node.y >= col || node.y < 0) {
    		return false;
    	}

    	return (grid[node.x][node.y] == PEOPLE);
    }
}