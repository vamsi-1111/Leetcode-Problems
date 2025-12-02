public class 322 {
    class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0; //if the amount is less than 1 meaning it is 0 you literally cannot create it with any number of coins so you return 0 because you can create that amount with 0 coins; furthermore, there is a restriction that states that amount cannot be less than 0

        int[] dp = new int [amount + 1]; //create a dp array with an extra amount because we always want to start at index 1 in a dp problem and discard the 0 index as it makes calculating the values of the coins easier. NOTE: Every value is set to 0 automatically

        for(int i = 1; i <= amount; i ++) { //iterate through the amount because that is what we are using to dictate the number of coins
            dp[i] = Integer.MAX_VALUE; //set the current value to a MAX VALUE

            for(int coin : coins) { //iterate through each value of coins to see which one will give which result; for example if we had coin values 5,10,15 then we would want to iterate through each type to see what value it gives for each i
                if(coin <= i && dp[i - coin] != Integer.MAX_VALUE) { //now we check if coins is less than i because if the coin is greater than the value of i then it is not possible to create i with coin as coin is too big. Then we must check if i - coin, which gives the amount remaining in our dp array, and if that value in the dp array is Integer.MAX_VALUE that means that it is not possible to make the amount with this specific coin value. So once we check off these test cases then we can move on.
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]); //we will then find out what the minimum is. The reason we do dp[i - coin] + 1 is because we have to account for the coin we are subtracting to find out the total number of coins at this specific i value in the dp array. 
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) { //once done we do that we see if the last value is Integer.MAX_VALUE if it is then we return -1 as this means it is not possible to create this value
            return -1;
        }
        else {
            return dp[amount]; //However, if it is not that means it is possible then we can just return the last value in the dp
        }
    }
}
}
