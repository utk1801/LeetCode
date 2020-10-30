import java.util.Stack;

public class maximalRectangle {
    public static void main(String[] args) {
        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.print(maximalRectangle(matrix));
    }

    static int maximalRectangle(char[][] matrix) {
            int r=matrix.length;
            if(r==0) return 0;
            int c=matrix[0].length;
            int[] h=new int[c+1];
            int max=0;

            //formulate histogram, for each subsequent rows staring from row 0
            for(int row=0;row<r;row++){
                Stack<Integer> st=new Stack();
                st.push(-1);
                for(int i=0;i<=c;i++){
                    if(i<c && matrix[row][i]=='1')
                        h[i]+=1;
                    else h[i]=0;

                    //max area under histogram logic, using stack.
                    while(st.peek()!=-1 && h[i]<h[st.peek()]){
                        max=Math.max(max,h[st.pop()] * (i-st.peek()-1));
                    }
                    st.push(i);
                }
            }
            return max;
        }
    }
