import java.util.Stack;

public class Pattern132 {
    public static void main(String[] args) {
        int[] nums={3,1,4,2};
        System.out.print(find132pattern(nums));
    }

        static boolean find132pattern(int[] nums) {
            Stack<Integer> st=new Stack();
            int n=nums.length;
            int[] min=new int[n];
            min[0]=nums[0];

            for(int i=1;i<n;i++){
                min[i]=Math.min(nums[i],min[i-1]);
            }
//Storing minimum of 132 in min[] , 2nd largest num in Stack, and checking and return true when
// current num which > stack's top.
            for(int j=n-1;j>=0;j--){
                if(nums[j]>min[j]){
                    while(!st.isEmpty() && st.peek()<=min[j])
                        st.pop();
                    if(!st.isEmpty() && st.peek()<nums[j])
                        return true;
                    st.push(nums[j]);
                }
            }
            return false;
        }
    }

