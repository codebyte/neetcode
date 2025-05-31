package sorting;

import java.util.*;


class Element {
    Integer freq;
    int id;

    Element(int id, int freq) {
        this.id = id;
        this.freq = 0;
    }

}

public class FrequentElements {


    public static int[] topKFrequent(int[] arr, int k) {
        Map<Integer, Element> map = new HashMap<>();
        PriorityQueue<Element> queue = new PriorityQueue<>((task1, task2) -> Integer.compare(task1.freq, task2.freq));

        for (int num : arr) {
            map.putIfAbsent(num, new Element(num, 0));
            map.get(num).freq++;
        }

        for (Map.Entry<Integer, Element> entry : map.entrySet()) {
            Element ele = entry.getValue();

            if (queue.size() == k) {
                if (ele.freq > queue.peek().freq) {
                    queue.poll();
                    queue.add(ele);
                }
            } else {
                queue.add(ele);
            }
        }

        //return queue.stream().toList().stream().map(x -> x.id).toList();
        int[] result = new int[queue.size()];

        for (int i = 0; !queue.isEmpty(); i++) {
            result[i] = queue.poll().id;
        }

        return result;
    }


    public static void main(String args[]) {

        int a[] = {1, 1, 3, 3, 2, 2, 5, 5, 5, 7, 7, 7};

        System.out.println(topKFrequent(a, 2).toString());


    }
}
