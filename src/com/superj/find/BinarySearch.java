package com.superj.find;

/**
 * 二分查找
 */
public class BinarySearch {
    //非递归
    public static int binarySearch2(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (value == array[middle]) {
                return middle;
            }
            if (value > array[middle]) {
                low = middle + 1;
            }
            if (value < array[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }
    //递归
    public static int binarySearch4(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        return searchmy(array, low, high, value);
    }
    private static int searchmy(int array[], int low, int high, int value) {
        if (low > high)
            return -1;
        int mid = low + ((high - low) >> 1);
        if (value == array[mid])
            return mid;
        if (value < array[mid])
            return searchmy(array, low, mid - 1, value);
        return searchmy(array, mid + 1, high, value);
    }
}
