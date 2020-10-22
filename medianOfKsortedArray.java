import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class medianOfKsortedArray {
    public static void main(String[] args) {
        int[][] nums={{0,1,2},{3,4,6},{3,4,5,8}};
        System.out.println(findMedian(nums));
    }

    static class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    static double findMedian(int[][] nums) {
// write your code here
        if (nums == null || nums.length == 0) {
            return 0.0;
        }

        double[] median = new double[2];
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        HashMap<Integer, Queue<Coordinate>> map = new HashMap<Integer, Queue<Coordinate>>();
        int count = 0;
        int total = getTotal(nums, heap, map);
//        System.out.println(heap);
//        System.out.println(map);
//        System.out.println(total);
        while (count <= total/2 && !heap.isEmpty()) {
            int curr = heap.poll();
            Coordinate coord = map.get(curr).poll();
            if (map.get(curr).isEmpty()) {
                map.remove(curr);
            }

            if (coord.y < nums[coord.x].length - 1) {
                int next = nums[coord.x][coord.y + 1];
                heap.offer(next);
                if (map.containsKey(next)) {
                    map.get(next).offer(new Coordinate(coord.x, coord.y + 1));
                } else {
                    Queue<Coordinate> queue = new LinkedList<Coordinate>();
                    queue.offer(new Coordinate(coord.x, coord.y + 1));
                    map.put(next, queue);
                }
            }

            if (count == total/2 - 1) {
                median[0] = curr;
            }
            if (count == total/2) {
                median[1] = curr;
            }
            count++;
        }

        // System.out.println("count: " + count + ", median: " + Arrays.toString(median));
        return total % 2 == 0 ? (median[0] + median[1])/2 : median[1];
    }

    private static int getTotal(int[][] nums, PriorityQueue<Integer> heap, HashMap<Integer, Queue<Coordinate>> map) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i].length;
            if (nums[i].length > 0) {
                heap.offer(nums[i][0]);
                if (map.containsKey(nums[i][0])) {
                    map.get(nums[i][0]).offer(new Coordinate(i, 0));
                } else {
                    Queue<Coordinate> queue = new LinkedList<Coordinate>();
                    queue.offer(new Coordinate(i, 0));
                    map.put(nums[i][0], queue);
                }
            }
        }
        return total;
    }

}

