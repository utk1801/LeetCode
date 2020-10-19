import java.util.TreeSet;

public class LISwith3Sum {
    public static void main(String[] args) {
        int[] list={9, 1, 5, 3, 4};
        System.out.println(solve(list));
    }
/*At first, we might be tempted to use a dynamic programming solution, but we can take advantage of the fact that we're only looking for 3 numbers.

The idea behind my solution is that once we have the middle number, we kinda know what the other 2 have to be. The 3rd should be as large as possible, which we can precalculate with prefix sums. The first one should be the largest number less than the current number(before it), which we can keep track of using a TreeSet.

Time complexity: O(N log(N))
Space complexity: O(N)
*/
    private static int solve(int[] nums) {
        // Write your code here
        int max=0;
        int n=nums.length;
        TreeSet<Integer> ts=new TreeSet();
        int[] prefixSum=new int[n+1];
        prefixSum[n]=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            prefixSum[i]=Math.max(nums[i],prefixSum[i+1]);
        }

        for(int i=0;i<n-1;i++){
            Integer f=ts.floor(nums[i]);
            if(f!=null && prefixSum[i+1]>=nums[i])
                max=Math.max(max,f+nums[i]+prefixSum[i+1]);
            ts.add(nums[i]);
        }
        return max;
    }
}
