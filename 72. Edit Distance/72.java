class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int [m + 1][n + 1]; //creating dp array always plus 1

        for(int i = 1; i <= m; i++) { //iterate through and fill each row with the number of letters because as we fill up our dp it will and can represent the maximum number of letters we need to change in order to get the same word.

            dp[i][0] = i;
        }

        for(int j = 1; j <= n; j++) {
        dp[0][j] = j;

        }

        for(int i = 1; i <= m; i++) { //begin iterating through our dp
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1]; //if there is equality between the 2 letters then we do dp[i - 1][j - 1] because this represents the minimum changes we needed to make in order to change everything before and this is relevant because equality between 2 letters means that we do not consider these as nothing needs to be changed so we take into consideration the numbers that are relevant when change was needed for everything that comes before.
                }
                else {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1; //we see what brings minimum operations either keeping it the same (removing the current letters), or going to the left one or right (adding or changing letters), and then we add 1 because we said that was the minimum for everything before, but now we have to consider these new letters that do not match
                }
            }
        }

    return dp[m][n]; //return the last value because that represents final answer

    }
}