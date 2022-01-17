package com.study.hard.one.MedianFinder;

import java.util.PriorityQueue;
import java.util.Queue;

//剑指 Offer 41. 数据流中的中位数
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
//如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
//
//例如，
//[2,3,4] 的中位数是 3
//[2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
//设计一个支持以下两种操作的数据结构：
//void addNum(int num) - 从数据流中添加一个整数到数据结构中。
//double findMedian() - 返回目前所有元素的中位数。
//
//输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
//
//输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000]
//
//链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
class MedianFinder {
    Queue<Integer> minQueue, maxQueue;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (minQueue.size() == maxQueue.size()) {
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        } else {
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        }
    }

    public double findMedian() {
        return minQueue.size() != maxQueue.size() ? minQueue.peek() : (maxQueue.peek() + minQueue.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */