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
        int n=3; int m=3;
        System.out.println(gridWays(0, 0, n, m));

    }
}
