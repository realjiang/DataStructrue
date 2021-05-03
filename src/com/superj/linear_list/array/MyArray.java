package com.superj.linear_list.array;

/**
 * 数组
 */
public class MyArray {
    private int []array;//数组容器
    private int size;//数组实际长度

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    public static void main(String[] args) {
        /**初始化*/
        //1.静态初始化
        //一维数组
        int[] arr11 = new int[]{1, 2, 3, 4, 5};
        int[] arr12 = {1, 2, 3, 4, 5};
        //二维数组
        int[][] arr21 = {{1,2}, {2, 3}, {4, 5}};
        //2.动态初始化
        //一维数组
        int[] arr13 = new int[10];
        //二维数组
        //确定二维长度
        int[][] arr22 = new int[4][3];
        //不确定二维长度
        int[][] arr23 = new int[5][];
        for(int i=0; i<arr23.length; ++i){
            arr23[i]=new int[i+1];
            for(int j=0; j<arr23[i].length; ++j){
                arr23[i][j]= i+j;
            }
        }

        /**
         * 查找和更新
         * 时间复杂度 O(1)
         */
        // 查找 arr[i]
        // 更新 arr[i] = ?
        /**插入*/
        //1.尾部插入 = 更新
        //2.中间插入
        //3.超范围插入 = 数组扩容+中间插入
        MyArray myArray = new MyArray(20);
        myArray.insert(0,2);
        myArray.insert(1,3);
        myArray.insert(0,5);
        // 输出数组
        myArray.output();
        /**删除*/
        myArray.delete(1);
    }

    /**
     * 输出数组
     */
    private void output() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 插入元素
     * @param index 下标
     * @param element 元素
     * 时间复杂度 O(n)
     */
    public void insert(int index,int element) {
        //判断访问下标是否超出范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        //如果数组实际元素达到数组容量上线，则对数据进行扩容
        if (size > array.length) {
            resize();
        }
        //从右向左循环，将元素逐个右挪一位
        for (int i = size -1; i >= index; i--) {
            array[i+1] = array[i];
        }
        //腾出位置放入新元素
        array[index] = element;
        //长度+1
        size++;
    }

    /**
     * 数组扩容
     * 时间复杂度 O(n)
     */
    private void resize() {
        int[] resizeArray = new int[array.length * 2];
        //从旧数组复制到新数组
        System.arraycopy(array,0,resizeArray,0,array.length);
        array = resizeArray;
    }

    /**
     * 删除元素
     * @param index 下标
     * @return 删除的元素
     * 时间复杂度 O(n)
     */
    private int delete(int index) {
        //判断访问下标是否超出范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        int deletedElement = array[index];
        //从左向右循环，将元素逐个左挪一位
        for (int i = index; i <= size; i++) {
            array[i] = array[i+1];
        }
        //长度+1
        size--;
        return deletedElement;
    }
}
