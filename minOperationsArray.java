import java.util.Arrays;

public class minOperationsArray {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(minMoves(nums)); // [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
        System.out.println(minMoves2(nums)); // [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
    }

    static int minMoves(int[] nums) {
        //a move is defined as adding 1 to all the elements except one, which is equivalent to decrementing 1 from a single element,
        int sum=0,min=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i:nums){
            sum+=i;
            min=Math.min(min,i);
        }

        return sum-(min*n);
    }

    static int minMoves2(int[] nums) {
        //a move is defined as incrementing a selected element by 1 or decrementing a selected element by 1.
        Arrays.sort(nums);
        int n=nums.length;
        if(n%2==1){
            int mid=nums[n/2];
            int res=0;
            for(int i=0;i<n;i++){
                res+=Math.abs(nums[i]-mid);
            }
            return res;
        }

        //if n is even.
        int m1=nums[n/2-1];
        int m2=nums[n/2];
        int res1=0,res2=0;
        for(int i=0;i<n;i++){
            res1+=Math.abs(nums[i]-m1);
            res2+=Math.abs(nums[i]-m2);
        }
        return Math.min(res1,res2);
    }

    //Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
    //Return the least number of moves to make every value in A unique.
}
