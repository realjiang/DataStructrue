package com.superj.find;

/**
 * 顺序查找
 */
public class SequentialSearch {
    public static int search(int[] a, int key) {
        int index = a.length - 1;
        if (key == a[index])
            return index;
        a[index] = key;
        int i = 0;
        while (a[i++] != key) ;
        return i == index + 1 ? -1 : i - 1;
    }
}