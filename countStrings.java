import java.util.ArrayList;
import java.util.List;

public class countStrings {
    public static void main(String[] args) {
        String s="xyzxxx";
        System.out.println(count(s));
    }

    static int count(String s){
        int ans=0;
        int n=s.length();
        String st=s+s;
        int i=0,j=n-1;
        while(j<st.length()){
            if(st.charAt(i++)==st.charAt(j++)) ans++;
        }
        return s.charAt(0)==s.charAt(n-1)?ans-1:ans;
    }
}
