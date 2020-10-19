import java.net.SocketOption;

public class CyclicShift {
    public static void main(String[] args) {
        int[] a={1,2,3,4};
        int[] b={3,1,4,2};
        int[] c={2,1,4,3};

        String a1="",b1="",c1="";
        for(int i:a){
            a1+=i;
        }
        for(int j:b){
            b1+=j;
        }
        for(int k:c){
            c1+=k;
        }
        String concat=a1+a1;
        boolean res=false;
        if(concat.contains(b1)) res=true;

        System.out.println(res);
    }
}
