package com.study.easy.one.reverseList;

//剑指 Offer 24. 反转链表
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
//链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = tail;
            tail = temp;
            temp = next;
        }
        return tail;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}