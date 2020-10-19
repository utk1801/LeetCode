import java.util.Stack;

public class HistogramArea {
    public static void main(String[] args) {
        int[] hist={2,1,5,6,2,3};
        System.out.println("Max Area of Histogram: "+maxArea(hist));
    }

    static int maxArea(int[] heights){
        Stack<Integer> st=new Stack();
        int n=heights.length;
        int maxArea=Integer.MIN_VALUE,area=0;
        int top;
        int i;
        if(n==0) return 0;
        for(i=0;i<n;){
            //push to stack if stack is currently empty or if the curr element > element on top
            if(st.isEmpty()|| heights[st.peek()]<=heights[i]){
                st.push(i++);
            }else{
                top=st.pop();
                //set area until current iteration
                if(st.isEmpty()){
                    area=heights[top]*i;
                }else{
                    area=heights[top]*(i-st.peek()-1); //remember this!!
                }
            }
            maxArea=Math.max(area,maxArea);
        }

        //after going thru entire input set, check for maxArea again,till the stack gets empty.
        while(!st.isEmpty()){
            top=st.pop();
            if(st.isEmpty())
                area=heights[top]*i;
            else
                area=heights[top]*(i-st.peek()-1);

            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }

}
