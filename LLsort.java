public class LLsort {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    ////
    //merge sort a LL
    ////
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev=null,slow=head,fast=head;
        //At the end of this loop, we'l have 2 LL : head->prev and slow->fast
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=null; //split the LL into 2 halves:first half ends at prev.

        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);

        return merge(l1,l2);
    }

    ListNode merge(ListNode l1,ListNode l2){
        ListNode l=new ListNode();
        ListNode dummy=l;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                dummy.next=l1;
                l1=l1.next;
            }else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy=dummy.next;
        }
        if(l1!=null){
            dummy.next=l1;
        }
        if(l2!=null){
            dummy.next=l2;
        }
        return l.next;
    }

    ////
    //Insertion Sort on a Linked List.
    ////
    ListNode ans=null;
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode cur=head;
        ListNode next=null;
        ListNode res = new ListNode(0);

        while(cur!=null){
            next=cur.next;

            ListNode dummy=res;
            while(dummy.next!=null && dummy.next.val<cur.val){
                dummy=dummy.next;
            }

            //insert cur between dummy and dummy.next
            cur.next=dummy.next;
            dummy.next=cur;
            cur=next;
        }
        return res.next;
    }
}
