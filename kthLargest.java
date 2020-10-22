public class kthLargest {
    public static void main(String[] args) {
        int[] nums={3,2,3,1,2,4,5,5,6};
        int k=4;
        System.out.println(findKthLargest(nums,k));
    }

    //using Quick Select (Determinsitic Select) - Median of Medians.
    static int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int i=0,j=n-1;
        int index=n-k; //kth largest is (n-k)+1th smallest which is n-kth index(in 0-indexed array)
        while(i<j){
            int p=partition(nums,i,j); //get partition idx
            if(p<index) i=p+1; //search rightwards.
            else if(p>index) j=p-1; //search in left sunarray.
            else return nums[p]; //return if partition idx is reached at point index
        }
        return nums[i];

    }

    private static int partition(int[] nums,int start,int end){
        int pivot=nums[end];
        int i=start,j=start;
        while(j<end){
            if(nums[j]<pivot) {
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                i++;
            }
            j++;
        }
        int temp2=nums[i];
        nums[i]=nums[end];
        nums[end]=temp2;
        return i;
    }
}
