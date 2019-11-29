package cloud.jony.hello;


import java.util.*;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public static void main(String[] args) {
        ListNode[] l=new ListNode[2];
        int[] li=new int[]{-1,-1,-1};
        ListNode head=new ListNode(-2);
        ListNode n1=head;
        for (int i :
                li) {
            ListNode vNode = new ListNode(i);
            n1.next=vNode;
            n1=vNode;
        }
        l[0]=head;
        l[1]=null;

        Solution s=new Solution();
        System.out.println(s.mergeKLists(l));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> listNodes = new PriorityQueue<>(Comparator.comparingInt(p->p.val));
        for (ListNode head : lists) {
            if (head==null)
                continue;
            listNodes.add(head);
            ListNode n=head;

            while (n.next!=null){

                n=n.next;
                listNodes.add(n);
            }
        }


        ListNode vl=null;
        ListNode head=null;
        if (!listNodes.isEmpty()){
            vl=listNodes.remove();
            head=vl;
        }

        while (!listNodes.isEmpty()){

            ListNode vl2=listNodes.remove();
            vl.next=vl2;
            vl=vl2;

        }

        return head;


    }
}