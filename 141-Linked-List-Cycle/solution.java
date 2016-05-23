/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (head != null && head.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow.val == fast.val)
                return false;
        }
        
        return true;
    }
}