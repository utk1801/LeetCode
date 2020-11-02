import java.util.ArrayList;
import java.util.List;

public class bestMeetingPoint {
    public static void main(String[] args) {
        int[][] nums={{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.print(minTotalDistance(nums));
    }

    static int minTotalDistance(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        List<Integer> rCoord=new ArrayList();
        List<Integer> cCoord=new ArrayList();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    rCoord.add(i);
                }
            }
        }

        for(int j=0;j<c;j++){
            for(int i=0;i<r;i++){
                if(grid[i][j]==1){
                    cCoord.add(j);
                }
            }
        }

        return minDist(rCoord)+minDist(cCoord);
    }

    static int minDist(List<Integer> num){
        int res=0;
        int i=0,j=num.size()-1;
        //finds median for the given array;
        while(i<j)
            res+=num.get(j--)-num.get(i++);

        return res;
    }
}
