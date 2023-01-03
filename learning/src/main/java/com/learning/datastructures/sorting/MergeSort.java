package com.learning.datastructures.sorting;

import java.util.Arrays;

/*
1. divide the array in to half
2. sort the first half
3. sort the second half
4. merge the two sorted half's in to single array
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4,12,3,5,9,6,3,1,15,13};
//        System.out.println("Before sorting : " + Arrays.toString(arr));
//        arr = mergeSort(arr);
//        System.out.println("After sorting : " + Arrays.toString(arr));
        System.out.println("Before sorting : " + Arrays.toString(arr));
        mergeSortInPlace(arr,0, arr.length);
        System.out.println("After sorting : " + Arrays.toString(arr));
    }

    private static int[] mergeSort(int[] arr) {
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] firstHalf = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] secondHalf = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(firstHalf, secondHalf);
    }

    private static int[] merge(int[] firstHalf, int[] secondHalf) {
        int[] arr = new int[firstHalf.length + secondHalf.length];
        int i = 0,j = 0,k=0;
        while(i < firstHalf.length && j < secondHalf.length) {
            if(firstHalf[i] < secondHalf[j]){
                arr[k] = firstHalf[i];
                ++i;
            } else {
                arr[k] = secondHalf[j];
                ++j;
            }
            ++k;
        }
        while(i < firstHalf.length){
            arr[k] = firstHalf[i];
            ++i;
            ++k;
        }
        while(j < secondHalf.length){
            arr[k] = secondHalf[j];
            ++j;
            ++k;
        }
        return arr;
    }

    private static void mergeSortInPlace(int[] arr, int start,int end) {
        if(end - start == 1) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);
        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mixArr = new int[end - start];
        int i = start, j=mid, k=0;
        while (i<mid && j<end) {
            if(arr[i] < arr[j]) {
                mixArr[k] = arr[i];
                i++;
            }else {
                mixArr[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            mixArr[k] = arr[i];
            i++;
            k++;
        }
        while(j<end){
            mixArr[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < mixArr.length; l++) {
            arr[start+l] = mixArr[l];
        }
    }

}
