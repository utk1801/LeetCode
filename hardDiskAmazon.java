import java.util.Arrays;

public class hardDiskAmazon {
    public static void main(String[] args) {
        int noComp=3;
        int[] hardDisk={8,2,4};
        int segmentLen=2;
        System.out.println(maxDiskSpace(noComp,hardDisk,segmentLen));
    }

    private static int maxDiskSpace(int no, int[] hd, int seg) {
        int n=hd.length;
        if(seg>no) return 0;
        int min;
        int ans=Integer.MIN_VALUE;
        int len=n-seg+1;
        int k=0;
        int[] temp=new int[len];

        for(int i=0;i<=n-seg;i++) {
            min=hd[i];
            for(int j=i;j<seg;j++) {
                if(hd[i+j]<min) {
                    min = hd[i + j];
                }
            }
            temp[k++]=min;
        }

        System.out.println(Arrays.toString(temp));
        for(int i:temp) {
            ans=Math.max(ans,i);
        }
        return ans;
    }
}
