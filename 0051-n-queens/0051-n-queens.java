import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>> res= new ArrayList<>();
        char[][] board= new char[n][n];
        
        //  initialzie board with 'x'
        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');
        }
        solve(0,board,res);
        return res;
    }
    public void solve(int row,char[][] board,List<List<String> >res)
    {
        int n=board.length;
        // base condition
        if(row==board.length)
        {
            res.add(construct(board));
            return;
        }
        // main kaam here
        for(int j=0;j<n;j++)
        {
            if(isSafe(board,row,j))
            {
                board[row][j]='Q';
                solve(row+1,board,res);//recusrion function call;
                board[row][j]='.';//backtrack condition
            }
        }
    }

    public boolean isSafe(char[][] board,int row,int col)
    {
        // for the upword direction
        for(int i=row-1;i>=0;i--)
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }
        // left upper  diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
        {
             if(board[i][j]=='Q')
             {
                return false;
             }
        }

        // riht upper diagonal
         for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++)
        {
             if(board[i][j]=='Q')
             {
                return false;
             }
        }
     return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}
