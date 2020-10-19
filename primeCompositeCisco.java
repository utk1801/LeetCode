import java.util.Arrays;

public class primeCompositeCisco {

    private static boolean primeArr[]=new boolean[100002];
    public static void main(String[] args) {
        int[] n={10,11,12,41,21,2,3,5,7,};
        int len=n.length;
        String[] s=new String[len];
        int i=0;
        for(int nu:n){
            s[i++]=nu+"";
        }
        System.out.println(Arrays.toString(s));
        buildPrime();
        for(i=0;i<len;i++){
            int num=Integer.parseInt(s[i]);
            if(primeArr[num])
                System.out.println(" Prime "+num);
            else
                System.out.println(" Composite "+num);
        }
        System.out.print("\t");
    }

    private static void buildPrime(){
        for(int i=0;i<100001;i++)
            primeArr[i]=true;

        for(int i=2;i*i<100001;i++){
            if(primeArr[i]){
                for(int j=i*i;j<=100001;j+=i)
                    primeArr[j]=false;
            }
        }
    }
}