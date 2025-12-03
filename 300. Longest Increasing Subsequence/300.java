public class 300 {
    class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; //create a dp array

        for(int i = 1; i < nums.length; i++) { //iterate through i
            for(int j = 0; j < i; j++) { //for each i from the left till you reach i compare all values to i to see if there is a smaller substring possible
                if(nums[j] < nums[i]) { //check if the value of j on left is smaller than value on right of nums, which means increasing string is true so we perform the following
                    if(dp[j] + 1 > dp[i]) { //if the value is also bigger in the dp array, which is more important because if there is a bigger substring we want that then we will proceed by updating the value of dp as seen below
                        dp[i] = dp[j] + 1; //note since the first value starts at zero we are constantly finding all values that come before that index in the dp array and that is why we add 1 at the end
                    }
                }
            }
        }
        int maxValue = 0;
        for(int i = 0; i < dp.length; i++) {
            if(dp[i] > maxValue) {
                maxValue = dp[i]; //we find the max value in the array by iterating through it 
            }
        }
        return maxValue + 1; //find the max value and add 1 as said before 
    }
}
}
