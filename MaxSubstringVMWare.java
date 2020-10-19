import java.util.ArrayList;
import java.util.List;

public class MaxSubstringVMWare {
    public static void main(String[] args) {
        String s="asdfaa" ;
        System.out.println(maxSubstring(s));
    }

    private static String maxSubstring(String st){
        int len=st.length();
        String res="";

        for(int i=0;i<len;i++){
            if(res.compareTo(st.substring(i))<=0)
                res=st.substring(i);
        }
        return res;
    }
}
