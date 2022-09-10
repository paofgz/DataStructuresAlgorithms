package com.paofgz.mergesort;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        mergeSort(intArray, 0, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] input, int start, int end) {
        // If the array's length is 1 then we return since there is nothing to sort or split
        if (end - start < 2) {
            return;
        }

        // First we have to partition the array that we have been passed
        int mid = (start + end) / 2;
        // We call the function recursively but now with the left side of the partitioned array
        mergeSort(input, start, mid);
        // After the left side of the array has been handled, we do the same with the right side of the array
        mergeSort(input, mid, end);

        // After the two sides of the divided array have been handled we just have to merge them
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        // If the last element in the left array is less than the first element of the right array it means everithing is sorted since both arrays are already sorted
        if (input[mid - 1] <= input[mid])
            return;

        // If that is not the case whe have to compare the element ot sort them
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // we have to handle the missing elements taht have not been sorted (In case the left side has not got to mid then the rest of the elements go to the right)
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

    }
}
