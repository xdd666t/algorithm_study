package com.study.easy.two.removeElements;

//203. 移除链表元素
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//输入：head = [], val = 1
//输出：[]
//
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//链接：https://leetcode-cn.com/problems/remove-linked-list-elements/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode temp = preHead;
        while (temp.next != null) {
            if (temp.next.val != val) {
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return preHead.next;
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
