public class AM {
    public static void main(String args[]) {
        int a[] = {2,4,6,6,3};

        int c = 0;
        for(int i = 0; i < a.length; i++) {
            int s = 0;
            if(i-1 >= 0) {
                s += a[i-1];
            }
            if(i+1 < a.length) {
                s += a[i+1];
            }
            if(2 * a[i] == s)
                c++;
        }
        System.out.println(c);
    }
}
