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
        // Step 1: Check if there are at least k nodes available
        ListNode countPtr = head;
        int count = 0;
        while (countPtr != null && count < k) {
            countPtr = countPtr.next;
            count++;
        }

        // If fewer than k nodes remain, do not reverse
        if (count < k) {
            return head;
        }

        // Step 2: Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Step 3: Recursively process the rest and link
        // head is now the tail of the reversed k-group
        head.next = reverseKGroup(curr, k);

        // prev is the new head of this reversed k-group
        return prev;
    }
}