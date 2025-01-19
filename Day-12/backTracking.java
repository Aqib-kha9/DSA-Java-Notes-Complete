public class backTracking {

    // sum of n natural number
    public static int sumOfNNatlNum(int n){
        if(n==1){
            return 1;
        }
        int Snm1 = sumOfNNatlNum(n-1);
        int fn = n + Snm1;
        return fn;
    }

    // Nth fibonacci term find
    public static int fib(int n){
        if(n==1 || n==0){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1+fnm2;
        return fn;
    }

    // Check a array is sorted or not
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }

    // First Occurence
    public static int firstOccurence(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccurence(arr,key,i+1);
    }

    // Last Occurence 
    public static int lastOccurence(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1);
        if(isFound == -1 && arr[i]==key){
            return i;
        }
        return isFound;
    }

    // calculate x pow n O(n)
    public static int pow(int x,int n){
        if(n==0){
            return 1;
        }
        int xnm1 = pow(x, n-1);
        int fn = x * xnm1;
        return fn;
    }
    // Optimized pow function O(logn)
    public static int optimized(int x, int n){
        if(n==0){
            return 1;
        }
        int halfPow = optimized(x, n/2);
        int halfPowSq = halfPow*halfPow;
        // n is odd
        if(n%2!=0){
            halfPowSq = x*halfPowSq;
        }
        return halfPowSq;
    }

    // Tiling Problem 2 x n
    public static int tiling(int n){
        //Base Condition
        if(n==0||n==1){
            return 1;
        }
        //Vertically
        int fnm1 = tiling(n-1);

        // Horizontally
        int fnm2 = tiling(n-2);

        int fn = fnm1 + fnm2;
        return fn;
    }

    // Remove Duplicate in a string
    public static void rmvDpt(String str,int idx, StringBuilder newStr, boolean map[]){
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a']==true){
            rmvDpt(str, idx+1, newStr, map);
        }else{
            map[currChar-'a'] = true;
            rmvDpt(str, idx+1, newStr.append(currChar), map);
        }
    }

    // Friends Pairing Problem
    public static int calPairs(int n){
        if(n==1||n==2){
            return n;
        }
        // Single choice
        int fnm1 = calPairs(n-1);

        // pair
        int fnm2 = calPairs(n-2);
        int pairWays = (n-1) * fnm2;

        // total number of pairs
        int totalPairs = fnm1 + pairWays;
        return totalPairs;
    }



    public static void  main(String args[]){
        // System.out.println(sumOfNNatlNum(5));
        // System.out.println(fib(25));
        int [] arr = {1,2,4,3,7,2,6};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstOccurence(arr, 6, 0));
        // System.out.println(lastOccurence(arr, 2, 0));
        // System.out.println(optimized(2, 10));
        // System.out.println(tiling(4));
        String str = "apnaacooleegeeg";
        // rmvDpt(str, 0, new StringBuilder(""), new boolean[26]);
        System.out.println(calPairs(3));
    }
}
