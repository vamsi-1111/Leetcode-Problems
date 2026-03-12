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
                char value = stack.pop();
                if(map.get(value) == s.charAt(i)) {
                    return true;
                }
            }
        }
        return false;
    }
}