package com.learning.datastructures.searching;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,8,9,12,13,15,16};
        binarySearch(arr,9, 0, arr.length);
    }

    public static int binarySearch(int[] arr, int key, int i, int j){

        int mid= (i+j)/2;
        while(i<j){
            if(i<0){
                return -1;
            }
            if(arr[mid] == key){
                System.out.println("key found");
                return mid;
            } else if (key < arr[mid]) {
                return binarySearch(arr,key, i, mid-1);
            } else if (key > arr[mid]) {
               return binarySearch(arr, key, mid+1, j);
            }
        }
        return mid;
    }
}
