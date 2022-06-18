/*
* Given two non-empty LinkedList representing two non-negative integers, the most significant
* digit comes first and each of their node contains a single digit. For example,
* LinkedList [1,2,3] represents the number 123.
Write a Java program that add two numbers and return the sum as an integer.
* Example:
Input: l1 = [5,2,3], l2 = [1,9]
Output: 542
Explanation: l1 represents the number 523, l2 represents the number 19. 523 + 19 = 542.﻿
Assumption:
Two LinkedLists do not contain any leading zero except number 0 itself.
Please implement the method using the below signature:
int sumOfLinkedList(ListNode l1, ListNode l2)
* */
class ListNode{
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class SumOfTwoLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        l1_2.next = l1_3;
        l1.next = l1_2;
//        while(l1!= null){
//            System.out.println(l1.val);
//            l1 =  l1.next;
//        }
        ListNode l2 = new ListNode(9);
        ListNode l2_2 = new ListNode(9);
        ListNode l2_3 = new ListNode(3);
        l2_2.next = l2_3;
        l2.next = l2_2;
//        while(l2!= null){
//            System.out.println(l2.val);
//            l2 =  l2.next;
//        }
        int ans = sumOfLinkedList(l1, l2);
        System.out.println(ans);
    }
    public static int sumOfLinkedList(ListNode l1, ListNode l2){
        ListNode result = sumOfLinkedList_(l1, l2);
        String ans_str = "";
        while(result != null){
            ans_str += result.val;
            result = result.next;
        }
        return Integer.parseInt(ans_str);
    }
    private static ListNode sumOfLinkedList_(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        int carry = 0;
        ListNode currNode = result;
        while(l1 != null || l2!=null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = carry + v1 + v2;
            carry = sum / 10;
            currNode.next = new ListNode(sum % 10);
            currNode = currNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if(carry > 0)
            currNode.next = new ListNode((carry));
        return result.next;
    }
}
