import java.util.Stack;

public class Asteroids {
    public static void main(String[] args) {
        int[] asteroids={10,2,-5};
        System.out.println(asteroidCollision(asteroids));
    }

    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack();
        for(int a:asteroids){
            if(st.isEmpty()||a>0){ //initial push if stack is empty or incoming asteroid is +ve
                st.push(a);
            }
            else{
                while(true){
                    int top=st.peek();
                    if(top<0){  // push if stack top is negative.
                        st.push(a);
                        break;
                    }
                    else if(top==-a){ //incoming asteroid size is same as stack top's
                        st.pop();
                        break;
                    }
                    else if(top>-a){ // skip the asteroid. since its size < stack top
                        break;
                    }else{  //if incoming asteroid > stack top's
                        st.pop(); // remove the top element.
                        if(st.isEmpty()){
                            st.push(a);
                            break;
                        }
                    }
                }
            }
        }

        //to arrange last element in stack as last element in array.
        int[] ans=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}
