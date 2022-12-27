package com.learning.datastructures.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {8,2,3,4,7,8,12,34,56,78,98,123};
        linearSearch(arr,12);
    }

    private static void linearSearch(int[] arr, int key) {
        boolean isKeyFound = false;
        for (int i=0; i<arr.length; i++){
            if(key == arr[i]){
                isKeyFound = true;
                System.out.println("Key : "+key+" found at position " + i);
            }
        }
        if(!isKeyFound){
            System.out.println("Key not found in the list");
        }
    }
}
