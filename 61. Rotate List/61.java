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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0) { 
            return head; //these are edge cases where it will always return head
        }

        ListNode dummy = new ListNode(0); //Creates a new node called dummy with value 0
        ListNode ptr = head; //Creates a new pointer called ptr that points to head
        int length = 1; //Creates a length variable and sets it to 1

        while(ptr.next != null) { //keeps iterating until we reach the last node and we know we reached the last node once we see that the next value is null
            ptr = ptr.next; 
            length++; //use this to keep track and we start at 1 because when doing next the first node is counted for
        }
        ptr.next = head; //at the very end we create a loop and loop it back to head 

        k = k % length; //if k is greater than length we need to do this in order to find out by how much are we moving it over by and account for the loop around
        if(k == 0) { //if k == 0 then that means we just return the normal linked list
            ptr.next = null; //over write the loop creation and break the loop 
            return head; //return head
        }
        else {
            int tail = length - k; //find the difference becuase that tells where the new list starts
            ListNode newTail = head; //create a pointer called newTail and make it start at head
            for(int i = 1; i < tail; i++) { //iterate through the list and we start at one so it takes us to one node before the node that starts at the new list
                newTail = newTail.next; //used to iterate
            }
            ListNode finalResult = newTail.next; //create a new pointer and set it to the node that will start at the next list
            newTail.next = null; //we then once we make finalResult point to the starting node we can take newTail and set it to null
            return finalResult; //then we return the results 
        }

    }
}