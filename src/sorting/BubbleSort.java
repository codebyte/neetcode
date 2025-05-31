package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void sort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
    }


    public static void main(String args[]) {
        int a[] = {10, 5, 67, 3, 121, -3};
        sort(a);
        System.out.println(Arrays.toString(a));


    }
}
