import java.util.Arrays;

public class nextPermutation {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(nextPerm(nums));
    }

    private static String nextPerm(int[] nums) {
        int n=nums.length;
        int i=n-2; // start from 2nd last index
        while(i>=0 && nums[i+1]<=nums[i]){ // Find 1st idx i that breaks descending order(first smaller from right)
            i--;
        }
        if(i!=-1){  // If array is completely descending (i==-1) , just return reverse ,
            int j=n-1; // Start from the end
            while(j>=0 && nums[j]<=nums[i]) // Find rightmost first larger id j (immediate higher element)
                j--;
            swap(nums,i,j); // Switch i and j
        }
        System.out.println("After Swap: \n"+Arrays.toString(nums));
        reverse(nums,i+1,n-1); // Reverse the descending sequence
        System.out.println("After Reverse: ");
        return Arrays.toString(nums);
    }

     private static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    private static void reverse(int[] nums,int a,int b){
        while(a<b) swap(nums,a++,b--);
    }
}
