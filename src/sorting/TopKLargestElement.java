package sorting;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKLargestElement {

    public static int findKthLargest(int a[], int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            // case full
            if (q.size() == k) {
                if (a[i] > q.peek()) {
                    q.poll();
                    q.add(a[i]);
                }
            } else {
                q.add(a[i]);
            }
        }
        return q.peek();
    }

    public static void main(String args[]) {
        int a[] = {2, 3, 1, 1, 5, 5, 4};

        System.out.println(findKthLargest(a, 3));

    }

}
