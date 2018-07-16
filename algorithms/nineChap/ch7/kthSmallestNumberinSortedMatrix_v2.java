//  二分法
class ResultType {
    public int num;
    public boolean exists;
    public ResultType(boolean e, int n) {
        exists = e;
        num = n;
    }
}
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    

    //找出在矩阵中，<= value的数字的个数，且看value是否存在于矩阵中
    public ResultType check(int value, int[][] matrix) { 
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean exists = false;
        int num = 0;  //<= value的数字的个数
        int i = n - 1, j = 0;
        while (i >= 0 && j < m) { //矩阵中最左下角那个数
            if (matrix[i][j] == value)
                exists = true;
                
            if (matrix[i][j] <= value) {
                num += i + 1;
                j += 1; //往右走
            } else {
                i -= 1; //往上走
            }
        }
        
        return new ResultType(exists, num);
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int n = matrix.length;
        int m = matrix[0].length;
        
        int left = matrix[0][0];
        int right = matrix[n - 1][m - 1];
        
        // left + 1 < right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            ResultType type = check(mid, matrix);
            if (type.exists && type.num == k) {
                return mid;
            } else if (type.num < k) {  // <= mid的数的个数少于k个，因此mid要增大
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}