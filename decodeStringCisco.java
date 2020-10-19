import java.util.Arrays;
import java.util.Stack;

public class decodeStringCisco {
    public static void main(String[] args) {
        String s="((a){3}bc(de){3}){2}";
        System.out.println(decode(s));
    }

    private static String decode(String st){
        Stack<Character> res=new Stack<>();
        Stack<Character> sub=new Stack<>();
        int cur_num=0,i=0,j=0,idx=0;
        String rep="";

        for(char c:st.toCharArray()){
            if(c=='(' || c==')' || Character.isAlphabetic(c)){
                res.push(c);
                cur_num=0;
                i++;
            }
            System.out.println(res);
            if(c=='{') {
                idx=st.indexOf(c,i-1);
                System.out.println("index of { : "+idx);
                j=idx+1;
                while(st.charAt(j)!='}') {
                    cur_num = cur_num * 10 + Integer.parseInt(String.valueOf(st.charAt(j++)));
                }
                System.out.println("cur_num: "+cur_num);
                System.out.println("Stack after ): "+res);
                res.pop();
                rep="";

                while(res.peek()!='(') {
                    sub.push(res.pop());
                }
                res.pop();
                System.out.println("Sub stack: "+sub);
                while(!sub.isEmpty()){
                    rep+=sub.pop();
                }
                System.out.println("rep: "+rep);
                System.out.println("length of rep: "+cur_num*rep.length());

                String repeated = rep.repeat(cur_num);

                System.out.println("repeated string : "+repeated);

                for(int k=0;k<repeated.length();k++)
                        res.push(repeated.charAt(k));
                i=j+1;
            }

        }
        System.out.println("Post adding repeated string : ");
        return res.toString();
    }
}
