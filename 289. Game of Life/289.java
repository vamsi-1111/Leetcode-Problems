class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length; 
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                int[][] directions = {
                    {-1 , -1},
                    {-1 , 0},
                    {-1 , 1},
                    {0 , -1},
                    {0 , 1},
                    {1 , -1},
                    {1, 0},
                    {1 , 1},
                };

                for(int[] dir : directions) { //for each row of directions with the two columns we give it to the array dir. We can do this because when we pass one row of a [][] array we are basically giving the single array one column. It becomes a double array only when there are multiple rows
                    int y = i + dir[0]; //add each value of first column to i to get the new value
                    int x = j + dir[1]; //add each value of second column to j to get the new value

                    if(x >= 0 && x < n && y >= 0 && y < m) {
                        if(board[y][x] == 1 || board[y][x] == -1) {
                            liveNeighbors++; //if the x and y value around board[i][j] is 1 or -1 then we increase liveNeighbors
                        }
                    }
                }

                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {  
                        board[i][j] = -1;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2;
                    }
                }



            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}