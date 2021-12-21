package com.study.nine.minNumber;

//45. 把数组排成最小的数
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
//输入: [10,2]
//输出: "102"
//
//输入: [3,30,34,5,9]
//输出: "3033459"
//
//链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strs) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    void quickSort(String[] strs, int low, int high) {
        if (low < high) {
            int mid = getMiddle(strs, low, high);
            quickSort(strs, low, mid - 1);
            quickSort(strs, mid + 1, high);
        }
    }

    int getMiddle(String[] strs, int low, int high) {
        String temp = strs[low];
        while (low < high) {
            while (low < high && (strs[high] + temp).compareTo(temp + strs[high]) >= 0) {
                high--;
            }
            strs[low] = strs[high];
            while (low < high && (strs[low] + temp).compareTo(temp + strs[low]) <= 0) {
                low++;
            }
            strs[high] = strs[low];
        }
        strs[high] = temp;
        return high;
    }
}

class Test {
    public static void main(String[] args) {
        int[] temp = new int[]{2, 43, 1, 8, 3, 9, 29};
        new Test().sort(temp);
        System.out.println("+++++++++++++++++++++");
        for (int num : temp) {
            System.out.println(num);
        }
    }


    void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = getMiddle(array, low, high);
            quickSort(array, low, mid - 1);
            quickSort(array, mid + 1, high);
        }
    }

    int getMiddle(int[] array, int low, int high) {
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = high;
            while (low < high && array[low] <= temp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp; // array[low] 和 array[high] 都行
        return low;
    }

}