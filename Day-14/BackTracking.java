public class BackTracking {
    // Print Array
    public static void print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

    // Find SubSets of a string
    public static void subSet(String str, int i, String ans){
        // Base Case
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        //Yes
        subSet(str, i+1, ans+str.charAt(i));
        //No
        subSet(str, i+1, ans);
    }

    public static void arrayBacktrack(int arr[], int i, int val){
        // Base case
        if(i == arr.length){
            print(arr);
            return;
        }
        arr[i] = val;
        arrayBacktrack(arr,i+1, val+1);
        arr[i] = arr[i]-2;
    }

    // Permutation 
    public static void findPermutation(String str, String ans) {
        //Base Case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //Recursion
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(newStr, ans+curr); 
        }
    }

    //print chess board
    public static void printBoard(char chessBoard[][]){
        System.out.println("----------chess board---------");
        for(int i=0; i<chessBoard.length; i++){
            for(int j=0; j<chessBoard.length; j++){
                System.out.print(chessBoard[i][j]+ " ");
            }
            System.out.println();
        }
        
    }

    // n Queen's
    public static void nQueens(char chessBoard[][], int row){
        //base case
        if(row==chessBoard.length){
            printBoard(chessBoard);
            return;
        }
        //place queens
        for(int j=0; j<chessBoard.length; j++){
            if(isSafe(chessBoard,row,j)){
                chessBoard[row][j] = 'Q';
                nQueens(chessBoard, row+1);
                chessBoard[row][j] = 'x';
            } 
        }
    }
    
    // is Safe function
    public static boolean isSafe(char chessBoard[][],int row, int col){
        // top
        for(int i=row-1; i>=0; i--){
            if(chessBoard[i][col]=='Q'){
                return false;
            }
        }
        // top diagonal left
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(chessBoard[i][j]=='Q'){
                return false;
            }
        }
        // top diagonal right
        for(int i=row-1, j=col+1; i>=0 && j<chessBoard.length; i--, j++){
            if(chessBoard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    // grid ways
    public static int gridWays(int i, int j, int n, int m){
        //Base case
        if(i==n-1 && j==m-1){
            return 1;
        }else if(i==n||j==m){
            return 0;
        }
        int x1 = gridWays(i+1, j, n, m);
        int y1 = gridWays(i, j+1, n, m);
        return x1+y1;
    }

    // sudoku solver
    public static boolean sudokuSolver(int sudoku[][], int row, int col){
        //Base case
        if(row==9){
            return true;
        }

        int nextRow = row, nextCol = col+1;
        if(col+1==9){
            nextRow = row+1;
            nextCol = 0;
        } 
        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku,nextRow,nextCol);
        }

        for(int digit=1; digit<=9; digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    //check is digit safe to place or not
    public static boolean isSafe(int sudoku[][],int row, int col, int digit){
        // col
        for(int i=0; i<=8; i++){
            if(sudoku[i][col]== digit){
                return false;
            }
        }

        // row
        for(int j=0; j<=8; j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }

        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        
        return true;
    }

    // print sudoku
    public static void printSudoku(int sudoku[][]){
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
        
    }


    // print solution
    public static void printSolution(int sol[][]){
        for(int i=0; i<sol.length; i++){
            for(int j=0; j<sol.length; j++){
                System.out.print(" "+ sol[i][j] +" ");
            }
            System.out.println();
        }
    }

    // function for check the path is safe or not
    public static boolean isSafe(int maze[][],int x, int y){
        //if(x,y outside maze) return false
        return (x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y]==1);
    }

    // solve maze funx
    public static boolean solveMaze(int maze[][]){
        int N = maze.length;
        int sol[][]=new int[N][N];
        if(solveMazeUtil(maze,0,0,sol)==false){
            System.out.print("Solution doesn't exists");
            return false;
        }
        printSolution(sol);
        return true;
    }

    // solve maze util funx
    public static boolean solveMazeUtil(int maze[][],int x, int y, int sol[][]){
        if(x==maze.length-1 && y==maze.length-1 && maze[x][y]==1){
            sol[x][y] = 1;
            return true;
        }
        // check if maze[x][y] is valid
        if(isSafe(maze, x, y)==true){
            if(sol[x][y]==1){
                return false;
            }
            sol[x][y]=1;
            if(solveMazeUtil(maze,x+1,y, sol)){
                return true;
            }
            if(solveMazeUtil(maze, x, y+1, sol)){
                return true;
            }
            sol[x][y] = 0;
            return false;
        }
        return false;
    }
   
    
    public static void main(String args[]){
        // String str = "abc";
        // // subSet(str, 0, "");
        // int[] arr = new int[5];
        // arrayBacktrack(arr, 0, 1);
        // print(arr);

        // findPermutation(str, "");
        // int n = 5;
        // char chessBoard[][] = new char[n][n];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         chessBoard[i][j] = 'x';
        //     }
        // }
        // nQueens(chessBoard,0);
        // int n=3; int m=3;
        // System.out.println(gridWays(0, 0, n, m));
        // int[][] sudoku = {
        //     {5, 3, 0, 0, 7, 0, 0, 0, 0},
        //     {6, 0, 0, 1, 9, 5, 0, 0, 0},
        //     {0, 9, 8, 0, 0, 0, 0, 6, 0},
        //     {8, 0, 0, 0, 6, 0, 0, 0, 3},
        //     {4, 0, 0, 8, 0, 3, 0, 0, 1},
        //     {7, 0, 0, 0, 2, 0, 0, 0, 6},
        //     {0, 6, 0, 0, 0, 0, 2, 8, 0},
        //     {0, 0, 0, 4, 1, 9, 0, 0, 5},
        //     {0, 0, 0, 0, 8, 0, 0, 7, 9}
        // };

        // if(sudokuSolver(sudoku, 0,0)){
        //     System.out.println("solution exists");
        //     printSudoku(sudoku);
        // }else{
        //     System.out.println("solution not exists");
        // }

        int maze[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,1,0},
                        {0,1,1,1}};
        solveMaze(maze);
        
        
    }
}
