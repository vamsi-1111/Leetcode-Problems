public class 5 {
    class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) { //base case for if the string is of length 1
            return s;
        }

        String LPS = ""; //this is the empty string we use for comparison
        for(int i = 1; i < s.length(); i++) {  //iterate through array
            int low = i; //pointer for low
            int high = i; //pointer for high

            while(s.charAt(low) == s.charAt(high)) { //if the value at low == value at high
                low--; //then decrease low to check next char
                high++; //increase high to check next char

                if(low == -1 || high == s.length()) { //if it goes out of bounds then break out of the while loop because that means even though the values are the same it is done iterating through the string 
                    break; //hence the break 
                }
            }

            String currentValue = s.substring(low + 1, high); //get the substring value of what we achieved so far again plus one on low because we want to start at the value that is not out of bounds or the value that is a match because substring includes low and excludes high
            if(currentValue.length() > LPS.length()) { //regular comparison to see which length is greater and then it will update accordingly 
                LPS = currentValue;
            }

            low = i - 1; //making it so that we are starting back at i but checking for even length palindromes 
            high = i; //high will stay at i but low will start at one below so that we can see the palindrome possibilties with even numbers

            //by checking both even and odd palindromes we allow for us to see all posibilities checking only odd may exclude even and checking only even may exclude odd

            while(s.charAt(low) == s.charAt(high)) { //do the same for even length palindromes which means there is no center value but rather start at the left and right of a string and keep moving either way accordingly 
                low--;
                high++;

                if(low == -1 || high == s.length()) {
                    break;
                }
            }

            currentValue = s.substring(low + 1, high);
            if(currentValue.length() > LPS.length()) {
                LPS = currentValue;
            }
   
        }
        return LPS;
    }
}
}
