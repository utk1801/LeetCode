public class minSubarrayLenSum {
    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int s=7;
        System.out.print(minSubArrayLen(s,nums));
    }

    static int minSubArrayLen(int s, int[] nums) {
        int n=nums.length;
        int left=0;
        int sum=0,min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(sum>=s){
                min=Math.min(min,i-left+1);
                sum-=nums[left++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}

