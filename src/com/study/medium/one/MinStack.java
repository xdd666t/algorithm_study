package com.study.medium.one;

import java.util.Stack;

//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
class MinStack {
    private final Stack<Integer> stackA;
    private final Stack<Integer> stackB;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
        if (stackB.isEmpty() || stackB.peek() >= x) {
            stackB.push(x);
        }
    }

    public void pop() {
        int value = stackA.pop();
        if (value == stackB.peek()) {
            stackB.pop();
        }
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}