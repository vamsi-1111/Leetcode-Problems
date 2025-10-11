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
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);
        ListNode less = lessDummy;
        ListNode great = greaterDummy;
        ListNode ptr = head;

        while(ptr != null) {
            if(ptr.val < x) {
                less.next = new ListNode(ptr.val);
                less = less.next;
                ptr = ptr.next;
            }
            else {
                great.next = new ListNode(ptr.val);
                great = great.next;
                ptr = ptr.next;
            }
        }
        less.next = greaterDummy.next;
        great.next = null;

        return lessDummy.next;
        
    }
}