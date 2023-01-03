package com.learning.datastructures.sorting;

import java.util.Arrays;

/* STEPS :

1. loop through each element
2. compare each and every element
3. if element in first loop is less than element in second loop then swap the positions.
4. continue step3 until entire array is sorted.
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4,12,3,5,9,6,3,1,15,13};
        System.out.println("before sorting : ");
        print(arr);
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {

        for(int outerIndex=0; outerIndex < arr.length; outerIndex++) {
            for(int innerIndex=0; innerIndex < arr.length; innerIndex++) {
                if(arr[outerIndex] <= arr[innerIndex]) {
                   arr = swap(arr,innerIndex,outerIndex);
                }
            }
        }
        System.out.println("After Sorting : ");
        print(arr);
    }
    private static void print(int[] arr) {

        Arrays.stream(arr).forEach( i -> {
            System.out.print(" " + i + " ");
        });
    }
    private static int[] swap(int[] arr, int innerIndex, int outerIndex) {
        int temp = arr[outerIndex];
        arr[outerIndex] = arr[innerIndex];
        arr[innerIndex] = temp;
        return arr;
    }
}
