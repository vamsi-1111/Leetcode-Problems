class Solution {
    public int maximalSquare(char[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0) { //base case if row + columns = 0 then return 0
            return 0;
        }


        int rows = matrix.length; 
        int columns = matrix[0].length;
        int [][] dp = new int[rows][columns]; 
        int maxSide = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; //if we are at the 0th index see if it is 1 or not and fill it accordingly
                    }
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j-1]), dp[i-1][j-1]) + 1; //otherwise see the top-left, left, and top and use Math.min to ensure all values are 1 and add plus 1 
                    }
                    maxSide = Math.max(maxSide, dp[i][j]); //then we take the current value we are at and then we update maxvalue by seeing if we found one
                }
            }
        }

        return maxSide * maxSide; //max value returns the max width so we need to square it to find the total number of boxes
    }
}