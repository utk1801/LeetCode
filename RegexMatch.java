public class RegexMatch {
    public static void main(String[] args) {
        String text="acd";
        String pattern="a*";
        System.out.println(isMatch(text,pattern));
    }
    public static boolean isMatch(String s, String p) {
        if(p.length()==0) return s.length()==0;
        boolean FirstMatch= s.length()>0 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        if(p.length()>=2&&p.charAt(1)=='*'){
            return(isMatch(s,p.substring(2))) || (FirstMatch&&isMatch(s.substring(1),p));
        }
        else {
            return FirstMatch&&isMatch(s.substring(1),p.substring(1));
        }
    }
}
