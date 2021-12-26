package com.study.medium.three.replaceSpace;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
class Solution {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c == ' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }
}
