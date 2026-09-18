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
        // Create a dummy node to start our new merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Loop as long as both lists have nodes to compare
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // Attach list1 node
                list1 = list1.next;   // Move list1 pointer forward
            } else {
                current.next = list2; // Attach list2 node
                list2 = list2.next;   // Move list2 pointer forward
            }
            current = current.next;   // Move current pointer forward
        }

        // Attach remaining nodes if one list runs out before the other
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        // Return the merged list starting after the dummy node
        return dummy.next;
    }
}
