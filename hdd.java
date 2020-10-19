import java.util.Deque;
import java.util.LinkedList;
// Amazon OA2 Question
//Find the Maximum of all minimas in a Sliding Window of size 'k' in an array of size 'len'.
//Required Time Complexity : O(N) uses Deque approach.
//Reference: https://leetcode.com/problems/sliding-window-maximum/ (LC Hard)
//Another Reference: https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
//Video Reference: https://www.youtube.com/watch?v=5VDQxLAlfu0 (Gaurav Sen)
public class hdd {
    public static void main(String[] args) {
            int[] nums={1,3,-1,-3,5,3,6,7};
            int len=nums.length;
            int k=3;

            System.out.println("\nMaximum of all minimas in sliding window of size k is: "+maxDiskSpace(len,nums,k));
        }

    private static int maxDiskSpace(int len, int[] nums, int k){
        return printMax(nums,len,k);
    }

    static int printMax(int arr[], int n, int k)
    {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<>();

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; ++i) {
            // For every element, the previous larger elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] <= arr[Qi.peekLast()])
                Qi.removeLast(); // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        int max=Integer.MIN_VALUE;
        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the smallest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");
            max=Math.max(max,arr[Qi.peek()]);

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements larger than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] <= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the minimum element of last window
        System.out.print(arr[Qi.peek()]);
        max=Math.max(max,arr[Qi.peek()]);

        return max;
    }
}
