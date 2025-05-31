package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int a[]) {

        for (int i = 0; i < a.length; i++) {
            int smallest = a[i];
            int j = i;
            for (; (j > 0) && (smallest < a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = smallest;
        }
    }


    public static void main(String[] args) {
        int a[] = {34, 5, 12, -4, 7, 123};

        sort(a);

        System.out.println(Arrays.toString(a));


    }
}
