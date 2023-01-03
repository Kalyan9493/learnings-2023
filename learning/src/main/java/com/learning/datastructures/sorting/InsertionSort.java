package com.learning.datastructures.sorting;

import java.util.Arrays;

/*
    1. loop through the array.
    2. check the previous elements .
    3. if previous elements is less than the current element change the positions until it fits the position
    4. continue step3 until entire array is sorted
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {18,7,15,15,13,5,10,12,1,20,3};
        System.out.println("Before Sorting :");
        printArr(arr);
        arr = insertionSort(arr);
        System.out.println();
        System.out.println("After Sorting :");
        printArr(arr);
    }

    private static int[] insertionSort(int[] arr) {

        for(int i=1; i<arr.length; i++) {
            int key = arr[i];
            int j=i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }
}
