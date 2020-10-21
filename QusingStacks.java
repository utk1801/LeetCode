import java.util.Stack;

//Implement a Queue data structure using 2 Stacks
public class QusingStacks {
        /** Initialize your data structure here. */
        Stack<Integer> s1;
        Stack<Integer> s2;
        int front;

        public QusingStacks() {
            s1=new Stack();
            s2=new Stack();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(s1.isEmpty())
                front=x;
            while(!s1.isEmpty())
                s2.push(s1.pop());
            s2.push(x);
            while(!s2.isEmpty())
                s1.push(s2.pop());
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int pop=s1.pop();
            return pop;
        }

        /** Get the front element. */
        public int peek() {
            return s1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

