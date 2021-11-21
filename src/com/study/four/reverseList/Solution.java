package com.study.four.reverseList;

import java.util.List;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//链接：https://leetcode-cn.com/problems/reverse-linked-list/
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

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
