public class JumpGame {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(jump(nums));
        System.out.println(canJump(nums));
    }

    static boolean canJump(int[] nums) {
        int n=nums.length;
        int lastGoodPoint=n-1;
        for(int i=n-2;i>=0;i--){
            if(i+nums[i]>=lastGoodPoint)
                lastGoodPoint=i;
        }
        return lastGoodPoint==0;
    }

    static int jump(int[] nums) {
        int n=nums.length;
        int curEnd=0,jumps=0,curFarthest=0;
        //The reason we used i < length-1 is because it excludes the last value in nums. We don't need to care about furthestJump we can get from the last element.
        for(int i=0;i<n-1;i++){
            curFarthest=Math.max(curFarthest,i+nums[i]);
            if(i==curEnd){
                jumps++;
                curEnd=curFarthest;
            }
        }
        return jumps;
    }
}

