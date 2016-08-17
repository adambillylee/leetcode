/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((n1, n2)->(n1.val - n2.val));

        for (ListNode tmp : lists) {
            if (tmp != null)
                heap.add(tmp);
        }

        while (!heap.isEmpty()) {
            curr.next = heap.poll();
            curr = curr.next;

            if (curr.next != null)
                heap.offer(curr.next);
        }

        return dummy.next;
    }
}