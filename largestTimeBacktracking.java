import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestTimeBacktracking {
    public static void main(String[] args) {
        int[] A={1,2,5,2};
        System.out.println(largestTimeFromDigits(A));
    }

    private static String largestTimeFromDigits(int[] A){
        String s="";
        Arrays.sort(A);
        for(int i:A){
            s+=i;
        }
        List<String> res=new ArrayList<>();
        String ans="";
        List<String> perms=permute(s,res,new StringBuilder(),new boolean[s.length()]);
        for(String st:perms){
            String HH=st.substring(0,2);
            String MM=st.substring(2);
            if(HH.compareTo("24")<0 && MM.compareTo("60")<0 && ans.compareTo(HH+":"+MM)<0)
                ans=HH+":"+MM;
        }
        return ans;
    }

    private static List<String> permute(String s, List<String> res, StringBuilder temp,boolean[] used){
        if(temp.length()==s.length())
            res.add(temp.toString());
        else{
            for(int i=0;i<s.length();i++){
                if(used[i] || i > 0 && s.charAt(i) == s.charAt(i-1) && !used[i - 1]) continue;
                used[i]=true;
                temp.append(s.charAt(i));
                permute(s,res,temp,used);
                used[i]=false;
                temp.deleteCharAt(temp.length()-1);
            }
        }
        return res;
    }
}
