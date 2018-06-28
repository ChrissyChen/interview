public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        
        // colPositionForEachRow stores the column indices for each row. 
        // eg. n = 4, colPositionForEachRow = {1, 3, 0, 2} or {2, 0, 3, 1}
        List<Integer> colPositionForEachRow = new ArrayList<>();
        dfsHelper(colPositionForEachRow, n, results);
        return results;
    }
    
    private void dfsHelper(List<Integer> colPositionForEachRow,
                           int n, List<List<String>> results) {
        
        if (colPositionForEachRow.size() == n) {
            results.add(new ArrayList<String>(drawChessboard(colPositionForEachRow)));
            return;
        }
        
        for (int i = 0; i < n; i++) { //每一行的Q可以从index为0，一个个试着放到index为n-1
            if (!isValidPosition(i, colPositionForEachRow)) {
                continue;
            }
            colPositionForEachRow.add(i);
            dfsHelper(colPositionForEachRow, n, results);
            colPositionForEachRow.remove(colPositionForEachRow.size() - 1);
        }
    }
    
    private boolean isValidPosition(int currentCol, List<Integer> colPositionForEachRow) {
        int currentRow = colPositionForEachRow.size(); //现在在试着放的位置的row index
        
        for (int i = 0; i < currentRow; i++) {  // i代表rowIndex //只要跟之前的放固定的位置比较就好，那么就是colPositionForEachRow.size()
            if (colPositionForEachRow.get(i) == currentCol) { //看跟之前放的在不在一条竖直线上
                return false;
            }
            
            if (i - colPositionForEachRow.get(i) == currentRow - currentCol) {
                // 之前的点的横坐标-纵坐标的差是否等于现在尝试放入的点的横坐标-纵坐标的差
                // 如果相等表示这两点在一条左对角线上
                return false;
            }
            
            if (i + colPositionForEachRow.get(i) == currentRow + currentCol) {
                // 之前的点的横坐标+纵坐标的合是否等于现在尝试放入的点的横坐标+纵坐标的合
                // 如果相等表示这两点在一条右对角线上
                return false;
            }
        }
        return true;
    }
    
    private List<String> drawChessboard(List<Integer> colPositionForEachRow) {
        List<String> result = new ArrayList<>();
        int n = colPositionForEachRow.size();
        for (int i = 0; i < n; i++) { // row
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) { // col
                if (j == colPositionForEachRow.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}