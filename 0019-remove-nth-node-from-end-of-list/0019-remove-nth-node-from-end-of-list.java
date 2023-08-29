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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode realHead = new ListNode();
        realHead.next = head;
        
        int idx = 1;
        ListNode tmpNode = head;
        while(tmpNode.next != null){
            idx++;
            tmpNode = tmpNode.next;
        }
        int targetIdx = idx - n;
        
        // 해당 인덱스 전까지 이동
        ListNode node = realHead;
        for(int i=0; i<targetIdx; i++){
                node = node.next;
        }
        if(node.next.next != null){
        node.next = node.next.next;
        }else{
            node.next = null;
        }
        return realHead.next;
        
        
    }
}