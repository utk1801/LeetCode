import java.util.ArrayList;
import java.util.List;

public class decomposeIPAddress {
    public static void main(String[] args) {
        System.out.print(restoreIpAddresses("25525511135"));
    }

    static List<String> restoreIpAddresses(String s) {
        int n=s.length();
        List<String> res=new ArrayList();
        int[] segment=new int[4];
        helper(s,res,segment,0,0);
        return res;
    }

    static void helper(String s, List<String> res, int[] segment, int builderIdx, int segmentIdx){
        if(builderIdx==s.length() && segmentIdx==4){
            res.add(segment[0]+"."+segment[1]+"."+segment[2]+"."+segment[3]);
            return;
        }
        else if(builderIdx==s.length()||segmentIdx==4)
            return;

        for(int len=1;len<=3 && builderIdx+len<=s.length();len++){
            String sub=s.substring(builderIdx,builderIdx+len);
            int val=Integer.valueOf(sub);
            if(val>255|| len>=2 && s.charAt(builderIdx)=='0')
                break;
            segment[segmentIdx]=val;
            helper(s,res,segment,builderIdx+len,segmentIdx+1);
            segment[segmentIdx]=-1;
        }
    }
}
