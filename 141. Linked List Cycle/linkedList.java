
public class Solution {
    
    public boolean hasCycle(ListNode head) {

        ListNode slowptr = head; 
        ListNode fastptr = head; 
        while(slowptr != null && fastptr != null && fastptr.next != null) { 
            fastptr = fastptr.next.next; 
            if(fastptr == slowptr) { 
                return true; 
            }
        }

        return false; 
}