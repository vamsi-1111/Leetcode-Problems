class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i < wordDict.size(); i++) {
            if (wordDict.get(i).length() > maxLength) {
                maxLength = wordDict.get(i).length();
            }
            else {
                continue;
            }
        }

        int lengthOfString = s.length();
        boolean[] dp = new boolean[lengthOfString + 1];
        dp[0] = true;

        for(int i = 1; i <= lengthOfString; i++) {
            for(int j = i - 1; j >= Math.max(0, j - maxLength); j--) {
                if(dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[lengthOfString];
    }
}