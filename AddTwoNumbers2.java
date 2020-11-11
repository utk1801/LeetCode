import java.util.Stack;
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers2 {
    //7-2-4-3 + 5-6-4 = 7-8-0-7
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1=new Stack();
        Stack<Integer> st2=new Stack();
        ListNode res=new ListNode(-1);
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode cur=l1;
        while(cur!=null){
            st1.add(cur.val);
            cur=cur.next;
        }

        cur=l2;
        while(cur!=null){
            st2.add(cur.val);
            cur=cur.next;
        }

        int sum=0,carry=0;
        while(!st1.isEmpty()||!st2.isEmpty()){
            int x=!st1.isEmpty()? st1.pop():0;
            int y=!st2.isEmpty()? st2.pop():0;
            sum=(x+y+carry)%10;
            res.val=sum;
            carry=(x+y+carry)/10;
            ListNode head=new ListNode(carry);
            head.next=res;
            res=head;
        }

        //remove leading zeroes
        return res.val==0?res.next:res;
    }

    static void printList(ListNode l1, ListNode l2)
    {
        ListNode n = addTwoNumbers(l1, l2);
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
            }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printList(l1, l2);
    }
}

