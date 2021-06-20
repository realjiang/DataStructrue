package com.superj.sort;

import java.util.Arrays;

/**
 * 1 冒泡排序 - 鸡尾酒排序法 时间O(n2) 空间O(1)
 * 原理:一轮从左向右比较,一轮从右向左比较,以此类推
 */
public class BubbleSort {
    //从小到大排序
    public static void sort(int array[]) {
        int tmp = 0;
        for (int i = 0; i < array.length/2; i++) {//外层循环一次相当于一来回
            //有序标记,每一轮初始值为true,发生交换变为false
            boolean isSorted = true;
            //奇数轮从左到右比较和交换
            for (int j = i; j < array.length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //有元素交换,不是有序
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            //在偶数轮之前,将isSorted重新标记为true
            isSorted = true;
            //偶数轮从右往左比较和交换
            for (int j = array.length-i-1; j > i; j--) {
                if (array[j] < array[j-1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    //有元素交换,不是有序
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
