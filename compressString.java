public class compressString {
    public static void main(String[] args) {
        String s="teessslllla";
        System.out.println(compress(s));
    }

    private static String compress(String st){
        int n=st.length();
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        for (i = 0; i < n; i++) {

            // Count occurrences of current character
            int count = 1;
            while (i < n - 1 && st.charAt(i) == st.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(st.charAt(i));
            if (count > 1) sb.append(count);
        }
//        for(j=0;j<n;j++){
//            if(j==n-1 || st.charAt(j)==st.charAt(j+1)) cnt++;
//            else{
//                sb.append(st.charAt(j));
//                if(cnt!=1){
//                    sb.append(cnt);
//                    cnt=1;
//                }
//            }
//        }

        return sb.toString();
    }
}
