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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode [] ans = new ListNode[k];
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        int div = k>size? 1 : size/k;
        int rem = k>size? 0 : size%k;
        temp = head;
        ListNode last = temp;
        int count = 0;
        int index = 0;
        boolean remInc = false;
        while(temp!=null){
            if(count<div-1){
                temp = temp.next;
                count++;
            }else{
                if(rem>0 && !remInc){
                    temp = temp.next;
                    count++;
                    remInc = true;
                    rem--;
                    continue;
                }
                ans[index] = last;
                last = temp.next;
                temp.next = null;
                temp = last;
                count = 0;
                index++;
                remInc = false;
            }
        }
        return ans;
    }
}