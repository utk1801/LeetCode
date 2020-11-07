public class shortestUnsortedArray {
    public static void main(String[] args) {
        int nums[]={2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }

    static int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int min,max;
        int s=0,e=0,i,j;
        //find the start index of unsorted array.
        for(s=0;s<n-1;s++){
            if(nums[s]>nums[s+1]){
                break;
            }
        }

        //find the end index of unsorted array.
        for(e=n-1;e>0;e--){
            if(nums[e]<nums[e-1]){
                break;
            }
        }

        // System.out.println(s+" "+e);
        if(s==n-1) return 0;

        min=nums[s];max=nums[s];

        for(i=s+1;i<=e;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }

        // System.out.println(min+" "+max);

        int maxIdx=0,minIdx=0;
        for(i=0;i<s;i++){
            if(min<nums[i]){
                s=i;
                break;
            }
        }

        for(j=n-1;j>=e+1;j--){
            if(max>nums[j]){
                e=j;
                break;
            }
        }

        // System.out.println(s+" " + e);
        return e-s+1;
    }
}
