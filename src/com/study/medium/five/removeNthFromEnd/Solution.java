package com.study.medium.five.removeNthFromEnd;


import java.util.List;

//给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
//
//示例 1：
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode fast = head, low = res;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        low.next = low.next.next;
        return res.next;
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
