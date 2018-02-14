package intern;

public class Leco329 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                max = Math.max(max, findP(i,j,matrix, m, n,Integer.MIN_VALUE, dp));
            }
        }
        return max;
    }
    public int findP(int i, int j, int[][] matrix, int m, int n, int last, int[][] dp){
        if(i< 0 || i>=m || j<0 || j>=n || matrix[i][j] <= last)
            return 0;
        if(dp[i][j] > 0)
            return dp[i][j];
        int ret = 0;
        ret = Math.max(findP(i+1,j, matrix, m,n,matrix[i][j],dp),Math.max(findP(i-1,j, matrix, m,n, matrix[i][j],dp), Math.max(findP(i,j+1, matrix, m,n, matrix[i][j],dp), findP(i,j-1, matrix, m,n, matrix[i][j],dp))));
        dp[i][j] = ++ ret;
        return ret;
        
    }
	    
}
