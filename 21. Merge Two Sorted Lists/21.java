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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE); //We create a new singular node called dummy, which will have the value of Integer.MIN_VALUE 
        ListNode current = dummy; //This creates a pointer called current that starts at the first node of dummy. We do this because when editing the linked list of dummy we can move current along the linked list while dummy stays at the original position so once we are done creating the linked list we can return the value dummy.next.

        while(list1 != null && list2 != null) { //We will continue this while loop as long as BOTH list1 and list2 are NOT null, which means it will end even if one of them is null
            if(list1.val <= list2.val) { //The smaller value out of list1 and list2 will be the one that we append
                current.next = list1; //We say "hey take the next value current points to and make it list1"
                list1 = list1.next; //We then move list1 to the next value because we have already inserted this minimum vale to the linked list and it is time to look for the next
            } else {
                current.next = list2; //We do the opposite if list1.val > list2.val
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 == null) current.next = list2; //We add the remaining values of list1, which is how current.next = list1 works when we do this we basically add all the values from the location of the pointer in list1 all the way to the null, indicating the end of the list
        if(list2 == null) current.next = list1; //We add the remaining values of list2

        return dummy.next; //with our logic we can just add dummy.next
    }
}
