import java.util.Arrays;

public class Sudoku {
    int n=3;
    int N=n*n;
    char[][] board;
    int[][] row=new int[N][N+1];
    int[][] col=new int[N][N+1];
    int[][] box=new int[N][N+1];
    boolean sudokuSolved=false;

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        Sudoku s=new Sudoku();
        System.out.print(Arrays.deepToString(s.solveSudoku(board)));
    }

    char[][] solveSudoku(char[][] board) {
        this.board=board;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                char num=board[i][j];
                if(num!='.'){
                    int d=Character.getNumericValue(num);
                    placeNumber(d,i,j);
                }
            }
        }
        backtrack(0,0);
        return board;
    }

    void placeNumber(int d,int r,int c){
        int idx=(r/n) * n + c/n;
        row[r][d]++;
        col[c][d]++;
        box[idx][d]++;
        board[r][c]=(char)(d+'0');
    }

    void backtrack(int i,int j){
        if(board[i][j]=='.'){
            for(int d=1;d<=9;d++){
                if(couldPlace(d,i,j)){
                    placeNumber(d,i,j);
                    placeNextNumbers(i,j);

                    if(!sudokuSolved) removeNum(d,i,j);
                }
            }
        }
        else{
            placeNextNumbers(i,j);
        }
    }

    void placeNextNumbers(int r,int c){
        if(c==N-1 && r==N-1)
            sudokuSolved=true;
        else{
            if(c==N-1) backtrack(r+1,0);
            else backtrack(r,c+1);
        }
    }

    boolean couldPlace(int d,int r,int c){
        int idx=(r/n) * n + c/n;
        return row[r][d]+col[c][d]+box[idx][d]==0;
    }

    void removeNum(int d,int r,int c) {
        int idx = (r / n) * n + c / n;
        row[r][d]--;
        col[c][d]--;
        box[idx][d]--;
        board[r][c] = '.';
    }
}
