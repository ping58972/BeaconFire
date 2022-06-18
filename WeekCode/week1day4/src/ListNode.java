/*
 * Author: Ping Nalongsone Danddank.
 * email: ndanddank@gmail.com
 * Question 2: Use the given ListNode structure below to solve below questions.
 * */

public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next) {this.val=val; this.next=next;}

    // for testing
    public static void main(String[] args) {
        ListNode n5 = new ListNode(9);
        ListNode n4 = new ListNode(5, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n6 = new ListNode(2, n3);
        ListNode n2 = new ListNode(1, n6);
        ListNode n1 = new ListNode(1, n2);

        ListNode m5 = new ListNode(8);
        ListNode m4 = new ListNode(6, m5);
        ListNode m3 = new ListNode(5, m4);
        ListNode m2 = new ListNode(3, m3);
        ListNode m1 = new ListNode(2, m2);

        ListNode mergeList = merge(n1, m1);
        printListNode(mergeList);
        ListNode lEven = removeOdd(mergeList);
        System.out.println("After remove odd:");
        printListNode(lEven);
    }
    static void printListNode(ListNode node){
        ListNode temp = node;
        while(node != null){
            System.out.print(""+node.val+ "->");
            node = node.next;
        }
        System.out.println("null");
        node = temp;
    }
    // b. Remove ListNode with odd value from a LinkedList
    // Option A:
    // Time complexity O(n)
    // Space complexity O(1)
    static ListNode removeOdd(ListNode head){
        while( head != null){
            if(head.val % 2 == 0 ) break;
            head = head.next;
        }
        if( head == null) return null;
        ListNode result = head;
        ListNode last = null;
        while(head.next != null){
            if (head.next.val % 2 != 0) {
                if (head.next.next != null) {
                    ListNode temp = head.next.next;
                    while (temp!= null){
                        if(temp.val %2 != 0) temp = temp.next;
                        else break;
                    }
                    head.next = temp;
                }
            }
            last = head;
            if(head.next == null) break;
            head = head.next;
        }
        if(head.val % 2  != 0) last.next = null;
        return result;
    }
    // b. Remove ListNode with odd value from a LinkedList
    // Option B:
    // Time complexity O(n)
    // Space complexity O(n)
    static ListNode removeOdd_(ListNode head){
        if( head == null) return null;
        ListNode ans = new ListNode();
        ListNode result = ans;
        while(head != null){
            if (head.val %2 == 0){
                ans.next = new ListNode(head.val);
                ans = ans.next;
            }
            head = head.next;
        }
        return result.next;
    }

    // a. Merge two sorted LinkedList
    // Time complexity O(n+m) -> O(N)
    // Space complexity O(n+m) -> O(N)
    static ListNode merge(ListNode list1, ListNode list2){
        ListNode result = new ListNode();
        ListNode ans = result;
        while(list1 != null || list2 != null){
            if(list1 != null && list2 != null){
                if(list1.val < list2.val){
                    result.next = new ListNode(list1.val);
                    result = result.next;
                    list1 = list1.next;
                } else {
                    result.next = new ListNode(list2.val);
                    result = result.next;
                    list2 = list2.next;
                }
            } else{
                if(list1 == null){
                    result.next = new ListNode(list2.val);
                    result = result.next;
                    list2 = list2.next;
                } else {
                    result.next = new ListNode(list1.val);
                    result = result.next;
                    list1 = list1.next;
                }
            }

        }
        return ans.next;
    }
}
