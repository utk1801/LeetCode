import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class largestTime {
    public static void main(String[] args) {
        int[] A={1,2,4,1};
        System.out.println(largestTimeFromDigits(A));
    }

    private static String largestTimeFromDigits(int[] A) {
        List<String> res=new ArrayList<>();
        String s="";
        for(int i:A)
            s+=i;

        //Get all permutations of String s
        List<String> perms=permute(s,"",res);
        String ans="";

        for(String str:perms){
            String HH=str.substring(0,2);
            String MM=str.substring(2);
            if(HH.compareTo("24")<0 && MM.compareTo("60")<0 && ans.compareTo(HH+":"+MM)<0)
                ans=HH+":"+MM;
        }
        return ans;
    }

    private static List<String> permute(String s,String sofar,List<String> res){
        if(s.length()==0) {System.out.println(sofar);res.add(sofar);}
        else{
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                // Rest of the string after excluding the ith character
                String temp=s.substring(0,i)+s.substring(i+1);
                permute(temp,sofar+ch,res);
            }
        }
        return res;
    }
}

