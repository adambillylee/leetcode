/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        if (head.next == null)
            return true;

        ListNode s = head;
        ListNode f = head;
        ListNode prev = null;
        ListNode next = s.next;

        while (f.next != null && f.next.next != null) {
            f = f.next.next;

            s.next = prev;
            prev = s;
            s = next;
            next = next.next;
        }

        if (f.next != null) {
            s.next = prev;
            prev = s;
        }

        while (prev != null && next != null) {
            if (prev.val != next.val)
                return false;

            prev = prev.next;
            next = next.next;
        }

        return prev == null && next == null;
    }
}