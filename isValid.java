import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        String s="acdb";
        System.out.println(isValid(s));
    }

    static boolean isValid(String s) {
        int n=s.length();
        Map<Character,Character> map=new HashMap();
        map.put('b','a');
        map.put('d','c');
        map.put('f','e');
        Stack<Character> st=new Stack();
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                int top=st.isEmpty()?'#':st.pop();
                if(top!=map.get(c)) return false;
            }else{
                st.push(c);
            }
        }
        return st.isEmpty()?true:false;
    }
}
