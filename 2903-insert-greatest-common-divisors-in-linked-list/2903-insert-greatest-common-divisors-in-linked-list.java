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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        if (temp.next == null){
            return head;
        }
        ListNode next = temp.next;
        while(next!=null){
            int gcd = calculateGCD(temp.val, next.val);
            ListNode newNode = new ListNode(gcd);
            temp.next = newNode;
            newNode.next = next;
            temp = next;
            next = next.next;
        }
        return head;
    }

    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}