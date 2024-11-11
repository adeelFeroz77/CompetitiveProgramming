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
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode nxt = null;
            if(prev!=null){
                nxt = temp.next;
                temp.next = prev;
                prev = temp;
                temp = nxt;
            }else{
                prev = temp;
                temp = temp.next;
                prev.next = null;
            }
            // System.out.println(temp.val);
        }
        return prev;
    }
}