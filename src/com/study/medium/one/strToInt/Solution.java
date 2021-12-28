package com.study.medium.one.strToInt;

//剑指 Offer 67. 把字符串转换成整数
//写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
//
//首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
//当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
//该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
//注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
//在任何情况下，若函数不能进行有效的转换时，请返回 0。
//说明：
//假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
//
//输入: "42"
//输出: 42
//示例 2:
//
//输入: "   -42"
//输出: -42
//解释: 第一个非空白字符为 '-', 它是一个负号。
//     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
//
//输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
//
//输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//     因此无法执行有效的转换。
//
//输入: "-91283472332"
//输出: -2147483648
//解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
//     因此返回 INT_MIN (−231) 。
//
//链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
class Solution {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return 0;
        int mark = 1;
        int index = 1;
        if (chars[0] == '-') {
            mark = -1;
        } else if (chars[0] != '+') {
            index = 0;
        }

        int number = Integer.MAX_VALUE / 10;
        int result = 0;
        for (int i = index; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') break;
            if (result > number || (result == number && chars[i] > '7')) {
                return mark == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + (chars[i] - '0');
        }
        return result * mark;
    }
}

//class Solution {
//    public int strToInt(String str) {
//        //去前后空格
//        char[] chars = str.trim().toCharArray();
//        if (chars.length == 0) return 0;
//        //记录第一个符合是否为负数
//        int sign = 1;
//        //开始遍历的位置
//        int i = 1;
//        //如果首个非空格字符为负号，那么从位置1开始遍历字符串，并且结果需要变成负数
//        if (chars[0] == '-') {
//            sign = -1;
//        } else if (chars[0] != '+') { //如果首个非空格字符不是负号也不是加号，那么从第一个元素开始遍历
//            i = 0;
//        }
//        int number = Integer.MAX_VALUE / 10;
//        //结果
//        int res = 0;
//        for (int j = i; j < chars.length; j++) {
//            //遇到非数字直接退出
//            if (chars[j] > '9' || chars[j] < '0') break;
//                /*
//                    这里这个条件的意思为，因为题目要求不能超过int范围，所以需要判断结果是否越界
//                    因为res每次都会 * 10 ，所以外面定义了一个int最大值除以10的数字
//                    此时只需要保证本次循环的res * 10 + chars[j] 不超过 int 即可保证不越界
//                    res > number 意思是，此时res已经大于number了，他 * 10 一定越界
//                    res == number && chars[j] > '7' 的意思是，当res == number时，即：214748364
//                    此时res * 10 变成 2147483640 此时没越界，但是还需要 + chars[j]，
//                    而int最大值为 2147483647，所以当chars[j] > 7 时会越界                 */
//            if (res > number || (res == number && chars[j] > '7')) {
//                //根据字符串首负号判断返回最大值还是最小值
//                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            }
//            //字符获取数字需要 - '0' 的位移
//            res = res * 10 + (chars[j] - '0');
//        }
//        //返回结果，需要判断正负
//        return res * sign;
//    }
//}