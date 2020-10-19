public class DistinctDigitsVMWare {
    public static void main(String[] args) {
        int n=80,m=120;
        System.out.println(distinctDigits(n,m));
    }

    private static int distinctDigits(int n,int m){
        int ans=0;
        for(int i=n;i<=m;i++){
            int num=i;
            boolean[] visited=new boolean[10];

            while(num!=0){
                if(visited[num%10]) break;

                visited[num%10]=true;
                num/=10;
            }

            if(num==0) {
                ans++;
            }
        }
        return ans;
    }
}
