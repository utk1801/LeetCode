public class basicCalculator {
    public static void main(String[] args) {
        String s="3+5 / 2";
        System.out.print(calculate(s));
    }

        static int calculate(String s) {
            int len=s.length();
            if(s==null || len==0) return 0;
            int preVal=0;
            int res=0;
            char sign='+';
            for(int i=0;i<len;i++){
                int val=0;
                if(s.charAt(i) == ' ')  continue;
                while(i<len && Character.isDigit(s.charAt(i))){
                    val=val*10+(s.charAt(i)-'0');
                    i++;
                }

                if(sign=='+'){
                    res+=preVal;
                    preVal=val;
                }
                else if(sign=='-'){
                    res+=preVal;
                    preVal=-val;
                } else if(sign=='*'){
                    preVal=preVal*val;
                } else if(sign=='/'){
                    preVal=preVal/val;
                }

                if (i < len) { // getting new sign
                    sign = s.charAt(i);
                }
            }
            res+=preVal;
            return res;
        }
}
