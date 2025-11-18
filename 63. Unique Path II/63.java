class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] finalGrid = new int[m][n];

        for(int i = 0; i < m; i++) { 
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) { //if the first box or any box is 1 we immediately block it as 0 because a path through there is not possible
                    finalGrid[i][j] = 0;
                }
                else if(i == 0 && j == 0) {  //once we mark the first box any box any box after can be marked as 1 
                    finalGrid[i][j] = 1;
                }
                else if(i == 0) { //if it is in the first row then we choose the value from the column before 
                    finalGrid[i][j] = finalGrid[i][j - 1];
                }
                else if(j == 0) { //if it is in the first column then we choose the value from the row before 
                    finalGrid[i][j] = finalGrid[i - 1][j]; 
                }
                else {
                    finalGrid[i][j] = finalGrid[i][j - 1] + finalGrid[i - 1][j]; //we add the top and left value to get the current box value
                }
            }
        }

        return finalGrid[m-1][n-1]; //we return the bottom right box as our final answer 
    }
}
