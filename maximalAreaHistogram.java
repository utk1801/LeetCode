import java.util.Stack;

public class maximalAreaHistogram {
    public static void main(String[] args) {
        int[] height={2,1,5,6,2,3};
        System.out.print(largestRectangleArea(height));
    }

    static int largestRectangleArea(int[] heights) {
            Stack<Integer> st=new Stack();
            st.push(-1);
            int n=heights.length;
            int maxArea=Integer.MIN_VALUE,area=0;
            if(n==0) return 0;

            for(int i=0;i<=n;i++){
                while(st.peek()!=-1 && (i==n || heights[st.peek()] > heights[i])){
                    //set area until current iteration
                    maxArea=Math.max(maxArea,heights[st.pop()] * (i-st.peek()-1));
                }
                st.push(i);
            }

            return maxArea;
        }
    }

