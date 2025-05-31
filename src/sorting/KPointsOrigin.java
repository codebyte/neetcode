package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

class Point {
    int x;
    int y;
    int distance;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
        distance = (x * x) + (y * y);
    }
}


public class KPointsOrigin {

    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> queue = new PriorityQueue<>((task1, task2) -> Integer.compare(task2.distance, task1.distance));

        for (int i = 0; i < points.length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            if (queue.size() == k) {
                if (p.distance < queue.peek().distance) {
                    queue.poll();
                    queue.add(p);
                }
            } else {
                queue.add(p);
            }
        }

        int[][] result = new int[k][];
        for (int i = 0; !queue.isEmpty(); i++) {
            Point p = queue.poll();
            result[i] = new int[2];
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        return result;
    }


    public static void main(String args[]) {
        int a[][] = {
                {0, 2},
                //{2, 0},
                {2, 2}
        };

        int[][] result = kClosest(a, 1);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }


    }

}
