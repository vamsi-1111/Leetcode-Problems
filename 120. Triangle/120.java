class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size(); //we are getting the size of triangle
        int dp[][] = new int [height + 1][height + 1]; //initilize a table with an extra level because we will need this for when we are accessing values from the previous levels and not create an out of bounds error 
        for(int level = height - 1; level >= 0; level--) { //we are performing tabulation for this dynamic problem
            for(int i = 0; i < triangle.get(level).size(); i++) { //iterating through each column of the current level (row)
                dp[level][i] = triangle.get(level).get(i) + Math.min(dp[level + 1][i], dp[level + 1][i + 1]); //performing a dynamic programming equation to add the min value from the previous level from either value directly under or adjacent value to the current level and column we are on, and as it works its way to the top it will keep adding the minimum value till it reaches the top
            }
        } 

    return dp[0][0]; //since the min value is the final value it will be the first row and first column
    }
}