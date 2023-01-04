package com.learning.datastructures.sorting;

import java.util.Arrays;

/*
1. select the mid-element as pivot element.
2. make left side elements less than pivot
3. make right side elements greater than pivot
4. if rule violated, swap the items
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4,12,3,5,9,6,3,1,15,13};
        System.out.println("Before sorting : " + Arrays.toString(arr));
        quickSort(arr,0, arr.length-1);
        System.out.println("After sorting : " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low >= high){
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];
        while(start < end) {

            while(arr[start] < pivot){
                start++;
            }

            while(arr[end] > pivot){
                end--;
            }

            if(start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr, low, end);
        quickSort(arr,start, high);
    }
}
