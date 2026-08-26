// class Solution {
//     public static boolean is_valid(char[][] board, int row, int col) {
//         int r;
//         int c;
//         int n = board.length;
//         // three check here we have to apply
//         // we have to check the staright up
//         // we have to check the straight left diag
//         // and straight right diag for each col
//         r = row ;
//         while (r > 0) {
//             if (board[r][col] == 'Q') {
//                 return false;}
//                 r--;
            
//         }
//         r = row;
//         c=col;
//          while (r >= 0 && c >= 0) {
//             if (board[r][c] == 'Q') {
//                 return false;}
//                 r--;
//                 c--;
            
//         }
//         r = row;
//         c = col;
//         while (r >= 0 && c < n) {
//             if (board[r][c] == 'Q')
//                 return false;
//             r--;
//             c++;
//         }

//         return true;
//     }

//     public static void helper_fx(char[][] board, int index, List<List<String>> res, int n) {
//         if (index >= n) {
//             List<String> curr = new ArrayList<>();
//             for (int i = 0; i < n; i++) {
//                 curr.add(new String(board[i]));
//             }
//             res.add(curr);
//             return;
//         }

//         for (int c = 0; c < n; c++) {
//             // loop throught one complete column
//             // whereas index loops throught the complete rows
//             if (is_valid(board, index, c)) {
//                 board[index][c]='Q';

//                 helper_fx(board, index + 1, res, n);
//                 board[index][c] = '.';
//             }
//         }
//     }
//     public List<List<String>> solveNQueens(int n) {
//         // appraoch 1 you are given a n and expected
//         // list of list of string
//         // board banana padega hame
//         List<List<String>> res = new ArrayList<>();
//         // now how to do it
//         // board
//         char[][] board = new char[n][n];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 board[i][j] = '.';
//             }
//         }

//         helper_fx(board,0,res,n);
//         return res;
//     }

// }


class Solution {
    
    public boolean is_valid(char[][] board, int row, int col) {
        int r;
        int c;
        int n = board.length;
        
        // 1. Check straight up
        r = row;
        while (r >= 0) {
            if (board[r][col] == 'Q') {
                return false;
            }
            r--; // Moved outside the if condition
        }
        
        // 2. Check top-left diagonal
        r = row;
        c = col; // Initialized c before the loop
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--; // Changed to c-- to move left
        }
        
        // 3. Check top-right diagonal
        r = row;
        c = col;
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }
        
        return true;
    }
    
    public void helper_fx(char[][] board, int index, List<List<String>> res, int n) {
        // Base case: If index reaches n, all queens are placed successfully
        if (index >= n) {
            List<String> curr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                curr.add(new String(board[i])); // Correctly converts char[] to String
            }
            res.add(curr);
            return;
        }
        
        // Loop through columns in the current row
        for (int c = 0; c < n; c++) {
            if (is_valid(board, index, c)) {
                board[index][c] = 'Q'; // Use single '=' for assignment
                
                helper_fx(board, index + 1, res, n);
                
                board[index][c] = '.'; // Backtrack: Use single '=' to remove the queen
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // Use single '=' for assignment
            }
        }
        
        // Start the backtracking from row 0
        helper_fx(board, 0, res, n);
        
        return res;
    }
}