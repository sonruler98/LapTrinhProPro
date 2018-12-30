/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Arrays;

/**
 *
 * @author HoangTheSon_Computer
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {15, 6, 7, 89, 56, 324, 5, 10, 2, 3, 45, 66, 78};
        mergesort(array);
        System.out.println(Arrays.toString(array));
    }
    
    static void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length -1);
    }

    static void mergesort(int[] array, int[] helper, int low, int high) {
        if(low<high) {
            int middle = (low+high)/2;
            mergesort(array, helper, low, middle);
            mergesort(array, helper, middle+1, high);
            merge(array, helper, low, middle, high);
        }
    }

    static void merge(int[] array, int[] helper, int low, int middle, int high) {
        for(int i = low; i <= high; i++)
            helper[i]=array[i];
        int left = low;
        int right = middle + 1;
        int current = low;
        
        while(left <= middle && right <=high) {
            if(helper[left] <=helper[right]) {
                array[current] = helper[left];
                left++;
            } else {
                array[current] = helper[right];
                right++;
            }
            current++;
        }
        int remaining = middle - left;
        for(int i=0; i<=remaining; i++)
            array[current + i] = helper[left + i];
    }
}
