class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Validate Rows
        for(int row=0;row<9;row++){
            Set<Character> rowSet = new HashSet<>();
            for(int col=0;col<9;col++){
                if(board[row][col]=='.') continue;

                if(rowSet.contains(board[row][col])) return false;
                rowSet.add(board[row][col]);
            }
        }

        // Validate Cols
        for(int col=0;col<9;col++){
            Set<Character> colSet = new HashSet<>();
            for(int row=0;row<9;row++){
                if(board[row][col]=='.') continue;

                if(colSet.contains(board[row][col])) return false;
                colSet.add(board[row][col]);
            }
        }

        // Validate Boxes
        for(int sr=0;sr<9;sr+=3){
            int er = sr+2;
            for(int sc=0;sc<9;sc+=3){
                int ec = sc+2;
                if(!validBox(board,sr,er,sc,ec)) return false;
            }
        }

        return true;
    }

    private boolean validBox(char[][] board,int sr, int er,int sc, int ec){
        Set<Character> boxSet = new HashSet<>();
        for(int row=sr;row<=er;row++){
            for(int col=sc;col<=ec;col++){
                if(board[row][col]=='.') continue;

                if(boxSet.contains(board[row][col])) return false;
                boxSet.add(board[row][col]);
            }
        }

        return true;
    }
}