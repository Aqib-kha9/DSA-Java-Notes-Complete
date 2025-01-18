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

    public static void  main(String args[]){
        // System.out.println(sumOfNNatlNum(5));
        // System.out.println(fib(25));
        int [] arr = {1,2,4,6};
        // System.out.println(isSorted(arr, 0));
        System.out.println(firstOccurence(arr, 6, 0));
    }
}
