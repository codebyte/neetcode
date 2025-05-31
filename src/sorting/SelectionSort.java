package sorting;

import java.util.Arrays;

public class SelectionSort {


    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[smallest]) {
                    smallest = j;
                }
                swap(a, smallest, i);
            }
        }
    }


    public static void main(String args[]) {

        int a[] = {12, 4, 5, 67, 68, 9};

        sort(a);
        System.out.println(Arrays.toString(a));


    }

}
