package com.study.easy.one.CQueue;

import java.util.Stack;

//剑指 Offer 09. 用两个栈实现队列
//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
//分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//
//输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//
//链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
class CQueue {
    private Stack<Integer> stackAdd;
    private Stack<Integer> stackDelete;


    public CQueue() {
        stackAdd = new Stack<>();
        stackDelete = new Stack<>();
    }

    public void appendTail(int value) {
        stackAdd.push(value);
    }

    public int deleteHead() {
        if (stackDelete.isEmpty()) {
            while (!stackAdd.isEmpty()) {
                stackDelete.push(stackAdd.pop());
            }
            return stackDelete.isEmpty() ? -1 : stackDelete.pop();
        } else {
            return stackDelete.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */