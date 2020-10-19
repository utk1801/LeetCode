
import java.util.*;

class matchRegex {
    public static void main(String[] args) {
        String input=">><<";
        System.out.println(match(input));
    }
     static String match(String angles) {
        // Type your solution here
        int n=angles.length();
        StringBuilder sb=new StringBuilder();
        int openCount=0;
        int addLeadOpen=0;

        for(char c:angles.toCharArray()){
            if(c=='>')
            {
                if(openCount==0)
                    addLeadOpen++;
                else
                    openCount--;
            }
            else
            {
                openCount++;
            }
        }
        return new String(new char[addLeadOpen]).replace("\0","<")
                + angles
                + new String(new char[openCount]).replace("\0",">");
    }
}


