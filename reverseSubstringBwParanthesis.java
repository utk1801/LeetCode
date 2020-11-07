import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseSubstringBwParanthesis {
    public static void main(String[] args) {
        System.out.println(reverseParenthesis("(ed(et(oc))el)"));
        System.out.println(reverseParenthesisII("(ed(et(oc))el)"));

    }

    static String reverseParenthesis(String s) {
        int n=s.length();
        Stack<Character> st=new Stack();
        char[] ch=s.toCharArray();

        for(char c:ch){
            if(c==')'){
                Queue<Character> q=new LinkedList();
                while(!st.isEmpty() && st.peek()!='(')
                    q.add(st.pop());
                st.pop();
                while(!q.isEmpty()) st.push(q.poll());
            }else{
                st.push(c);
            }
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }

    static String reverseParenthesisII(String s) {
        int n=s.length();
        StringBuilder result=new StringBuilder(s);
        int startIdx=result.lastIndexOf("(");
        int endIdx=result.indexOf(")",startIdx);

        while(startIdx!=-1){
            StringBuilder sb=new StringBuilder(result.substring(startIdx+1,endIdx));
            sb.reverse();
            result.replace(startIdx,endIdx+1,sb.toString());
            startIdx=result.lastIndexOf("(");
            endIdx=result.indexOf(")",startIdx);
        }
        return result.toString();
    }
}
