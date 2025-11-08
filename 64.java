class Solution {
    public int minPathSum(int[][] grid) {

        int height = grid.length; //intilize height
        int width = grid[0].length; //initilize width

        for(int i = 1; i < width; i++) { //iterate through first row
            grid[0][i] = grid[0][i] + grid[0][i - 1]; //find out all values moving right
        }

        for(int j = 1; j < height; j++) { //iterate through first column
            grid[j][0] = grid[j][0] + grid[j - 1][0]; //find out all values moving left 
        }

//iterating through first row and first column so that we can backtrack and look at the values from the previous row or column and decide if moving down or left is the best choice

        for(int i = 1; i < height; i++) { //we iterate through the height starting from one row to the down 
            for(int j = 1; j < width; j++) { //we iterate through the width starting from one row to the left
                grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1]); //we perform dp where we add the previos row and column and try to see which value works best to get the minimum
            }
        }

        return grid[height - 1][width - 1]; //we then return the last value in the grid as that represents the min value
    }
}