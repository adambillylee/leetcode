/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode first = head;
        ListNode second = head.next;
        
        while (true) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;

            if (second.next != null && second.next.next != null) {
                first = first.next.next;
                second = second.next.next;
            }else {
                return head;
            }
        }
    }
}