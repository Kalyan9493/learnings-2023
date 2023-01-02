package com.learning.datastructures.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {18,7,15,15,13,5,10,12,1,20,3};
        System.out.println("Before Sorting :");
        printArr(arr);
        arr = selectionSort(arr);
        System.out.println();
        System.out.println("After Sorting :");
        printArr(arr);
    }

    private static int[] selectionSort(int[] arr) {

        for(int i=0; i<arr.length; i++){
            int minIndex = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach( i -> System.out.print(i + " "));
    }
}
