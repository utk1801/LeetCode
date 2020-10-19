public class compress {
    public static void main(String[] args) {
        String s = "teessslllla";
        System.out.println(compress(s));
    }

    private static String compress(String st) {
        int n = st.length();
        StringBuilder sb=new StringBuilder();
        int count=1,start=-1;
        char[] ch=st.toCharArray();
        for(int i=0;i<n;i++){
            if(i<n-1 && ch[i]==ch[i+1]){
//                if(start==-1) start=i;
                count++;
            }
            else{
                sb.append(ch[i]);
                if(count>1){
                    sb.append(count);
                    count=1;
//                    start=-1;
                }
            }
        }
        return sb.toString();
    }
}