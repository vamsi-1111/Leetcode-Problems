class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            else if(map.containsValue(s.charAt(i))) {
                if (!stack.isEmpty()) { //first you want to check that the stack is not empty because if it is empty and we just came across a value we need to return false that is why we were getting an error before 
                   if(map.get(stack.pop()) != s.charAt(i)) { //also better to iterate through the entire string and return if a false is found that immediately returning true because we only know its true at the very end once the stack is empty
                        return false; 
                    } 
                }
                else {
                    return false; //if the stack is empty (meaning no keys) and we come accross a value then we should return false
                }
            }
        }
        return stack.isEmpty(); //if the stack is empty meaning every value had a corresponding key then the answer is true.
    }
}