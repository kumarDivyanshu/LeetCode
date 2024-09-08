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
        int cnt =0;
        ListNode curr = head;
        while(curr != null)
        {
            cnt++;
            curr = curr.next;
        }
        int part = cnt/k;
        int rem = cnt%k;

        // List<ListNode> result = new ArrayList<>();
        curr = head;
        ListNode[] result = new ListNode[k];
        for(int i =0; i<k && curr!=null ; i++)
        {
            result[i] = curr;
            int currPart = part + (rem>0 ? 1 : 0);
            rem--;

            for(int j =1 ; j<currPart ; j++)
            {
                if (curr != null) {
                    curr = curr.next;
                }
            }

            if (curr != null) {
                ListNode nextPart = curr.next;
                curr.next = null; 
                curr = nextPart; 
            }
        }
        return result;
    }
}