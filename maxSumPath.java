    import java.io.*;
import java.util.*;

class maxSumPath {
    public static boolean isSafe(int x, int max, int min) {
        return x < max && x > min;
    }

    public static int optimalPathRecUtil(Integer[][] grid, int i, int j) {
        if (i >= grid[0].length && j <= -1)
            return 0;

        int max = 0;

        if (isSafe(i + 1, grid[0].length, -1)) {
            //System.out.println("i " + i + "j" + j);
            max = Integer.max(optimalPathRecUtil(grid, i + 1, j) + grid[j][i], max);
        }
        if (isSafe(j - 1, grid.length, -1)) {
            max = Integer.max(optimalPathRecUtil(grid, i, j - 1) + grid[j][i], max);
        }
        if (isSafe(i + 1, grid[0].length, -1) && isSafe(j - 1, grid.length, -1)) {
            max = Integer.max(optimalPathRecUtil(grid, i + 1, j - 1) + grid[j][i], max);
        }

        return max;
    }

    public static int optimalPathIterUtil(Integer[][] grid) {
        int[][] sum = new int[grid.length][grid[0].length];

        sum[grid.length - 1][0] = grid[grid.length - 1][0];

        for (int j = 1; j < grid[0].length; j++)
            sum[grid.length - 1][j] = sum[grid.length - 1][j - 1] + grid[grid.length - 1][j];

        for (int i = grid.length - 2; i >= 0; i--)
            sum[i][0] = sum[i + 1][0] + grid[i][0];

        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = 1; j <= grid[0].length - 1; j++) {
                sum[i][j] = Integer.max(sum[i + 1][j], sum[i][j - 1]) + grid[i][j];
                System.out.print(sum[i][j] + "  ");
            }
            System.out.println();
        }

        return sum[0][grid[0].length - 1];
    }

    /*
     **  Find the optimal path.
     */
    public static Integer optimalPath(Integer[][] grid) {
        int result = 0;
//        System.out.print(bestCostPath(grid));
        if (grid.length > 0) {
            result = optimalPathIterUtil(grid);
            System.out.println(result);
        }

        return result;
    }

    private static int bestCostPath(Integer[][] grid) {
        int r=grid.length,c=grid[0].length;
        for(int i=r-1;i>=0;i--){
            for(int j=0;j<c;j++){
                if(i==r-1 && j==0) grid[i][j]=grid[i][j];
                else if(j!=0 && i==r-1) grid[i][j]+=grid[i][j-1];
                else if(i!=r-1 && j==0) grid[i][j]+=grid[i+1][j];
                else grid[i][j]=Math.max(Math.max(Math.max(grid[i][j+1],grid[i-1][j]),grid[i+1][j]),grid[i][j-1])+grid[i][j];
            }
        }
        System.out.print(grid[0][c-1]);
        return grid[0][c-1];
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        boolean result = true;
        // Base test case
        result &= optimalPath(new Integer[][]
                {{1, 0, 0, 0, 5},
                 {1, 1, 1, 1, 0},
                 {2, 0, 0, 0, 0}}) == 11;
        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}

