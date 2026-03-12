class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/"); //split by /
        for(String dir : directories) { // iterating through the directories array
            if(dir.equals(".") || dir.isEmpty()) { //if it is . or " " then continue
                continue;
            }
            else if (dir.equals("..")) { // if it is .. then pop out the most recently added item from the stack given that the stack is not empty
                if (!stack.isEmpty()) { 
                    stack.pop();
                }
            }
            else {
                stack.push(dir); //if it is not . or .. then push the item onto the stack 
            }
        }
        return "/" + String.join("/", stack); //add a / to the begining and then join the stack with /
    }
}

//Lesson to learn always add the / at the end and for stack reversal can use String.join with /