package com.study.medium.nine.copyRandomList;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer 35. 复杂链表的复制
//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
// 还有一个 random 指针指向链表中的任意节点或者 null。
//
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
//
//输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
//
//输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
//
//链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}

//class Solution {
//    private Map<Node, Node> result = new HashMap<>();
//
//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//
//        if (!result.containsKey(head)) {
//            Node newNode = new Node(head.val);
//            result.put(head, newNode);
//            newNode.next = copyRandomList(head.next);
//            newNode.random = copyRandomList(head.random);
//        }
//        return result.get(head);
//    }
//}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
