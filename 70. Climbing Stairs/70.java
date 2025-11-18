class Solution {
    public int climbStairs(int n) {

        if (n == 1) {  
            return 1; //base case if it is 1 then we return 1
        }

        int[] dp = new int[n]; //intilize an array called dp of size n
        dp[0] = 1; //set the first step to 1 because it is only 1 1 jump
        dp[1] = 2; //set the first step to 2 because its only do 2 1 jumps or do 1 2 jump

        for(int i = 2; i < n; i++) { //iterate through the for loop starting from the values not initilized
            dp[i] = dp[i - 2] + dp[i - 1]; //the total number of ways can be calculated from adding the last two values. This works because there are only 2 ways to do this it is either take the last two ways to get to the steps and add 1 or add 2 respectively; therefore, we need to account for the last two ways to get to the current step by adding both possibilities.
        }

        return dp[n - 1]; //return the last value following 0 based indexing
    }
}