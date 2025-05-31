package sorting;

import java.util.Arrays;
import java.util.Random;

public class LargestElementInArray {

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition(int a[], int start, int end) {
        int pivot = new Random().nextInt(end - start) + start;

        swap(a, start, pivot);
        int left = start;

        for (int right = start + 1; right <= end; right++) {
            if (a[right] < a[start]) {
                left++;
                swap(a, left, right);
            }
        }
        swap(a, left, start);
        return left;
    }

    public static void qSelect(int a[], int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int pivot = partition(a, start, end);
        if (pivot < k) {
            qSelect(a, pivot + 1, end, k);
        } else {
            qSelect(a, start, pivot - 1, k);
        }
    }


    public static void main(String args[]) {
        int a[] = {10, 24, 5, 78, 9, 6, 12, 3};
        int k = 2;

        qSelect(a, 0, a.length - 1, a.length - k);

        System.out.println(Arrays.toString(a));
        System.out.println(a[a.length - k]);


    }

}
