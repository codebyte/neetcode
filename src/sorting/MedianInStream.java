package sorting;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStream {

    PriorityQueue<Integer> leftQ = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightQ = new PriorityQueue<>();


    public MedianInStream(int a[]) {
        System.out.println(findMedianStream(a));
    }

    public double findMedianStream(int a[]) {

        for (int i = 0; i < a.length; i++) {
            int ele = a[i];

            if (!rightQ.isEmpty() && ele < rightQ.peek()) {
                leftQ.add(ele);
            } else if (!leftQ.isEmpty() && ele > leftQ.peek()) {
                rightQ.add(ele);
            } else {
                leftQ.add(ele);
            }


            // Balancing the right
            if (rightQ.size() > leftQ.size() + 1) {
                leftQ.add(rightQ.poll());
            } else if (leftQ.size() > rightQ.size() + 1) {
                rightQ.add(leftQ.poll());
            }
            System.out.println("Left :" + leftQ.toString());
            System.out.println("Right :" + rightQ.toString());
        }


        if (leftQ.size() == rightQ.size()) {
            return (double) (leftQ.poll() + rightQ.poll()) / 2;
        }

        if (leftQ.size() >= rightQ.size() + 1) {
            return leftQ.poll();
        }

        if (rightQ.size() >= leftQ.size() + 1) {
            return rightQ.poll();
        }

        return 0;
    }


    public static void main(String args[]) {

        int a[] = {1, 2};

        MedianInStream m = new MedianInStream(a);


    }

}
