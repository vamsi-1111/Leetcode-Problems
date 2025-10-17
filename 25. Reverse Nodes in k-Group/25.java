/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null) return head; //Base Case 1
        if (k == 1) return head; //Base Case 2

        ListNode dummy = new ListNode(0); //Creates a dummy node
        dummy.next = head; //Makes dummy connect to head
        ListNode curr = head; //Makes a pointer called curr at head
        ListNode prev = dummy; //Makes a pointer called prev at dummy

        while(curr != null) { //We want to perform the following once curr reaches null
            boolean space = hasSpace(curr, k); //checks for space
            if (space) {
                prev = reverse(curr, prev, k); //reverses it and sets the current value it returns to prev
                curr = prev.next; //sets the new current value to come after prev
            } else {
                break;
            }
        }
        return dummy.next;  
    }

    private boolean hasSpace(ListNode curr, int k) { //if there is space it returns true otherwise if there is not enough space it returns false
        for(int i = 1; i <= k; i++) { //means the loop runs k times 
            if(curr == null) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    private ListNode reverse(ListNode curr, ListNode prev, int k) {
        for(int i = 0; i < k - 1; i++) { //means the loop runs k-1 times 
            ListNode nex = curr.next; //make nex come after cur as this is the node we want to push to the front
            curr.next = nex.next; //point curr to the node after nex because we want to push nex to the front; therefore, we must sever currs connection to nex by making curr connect to the next node
            nex.next = prev.next; //we want nex to come to the front of the list by making it come after prev, which is the value that comes before the start of the list
            prev.next = nex; //then we want prev to point to the new value we just pushed to the front of the list otherwise it would still be pointing to the nex.next value in regards to nex's latest position
        }
        return curr;
    } //this loop works by taking the value of nex, which is always the value that comes after curr, and then pushing that to the front. For example, if we had list dummy -> 1 -> 2 -> 3 -> 4 -> null and k = 4 this would be how it changes through each iteration: dummy -> 1 -> 2 -> 3 -> 4 -> null => dummy -> 2 -> 1 -> 3 -> 4 -> null => dummy -> 3 -> 2 -> 1 -> 4 -> null => dummy -> 4 -> 3 -> 2 -> 1 -> null, as you can see whatever value that is next to curr (1) gets pushed to the front. This is better than the original traversal method because it makes sure that the loop does not break it makes it continous otherwise we would have to connect it manually ourselves
}