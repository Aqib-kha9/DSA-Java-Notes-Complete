import java.util.*;
public class divideAndConquer {

    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    // public static void mergeSort(int arr[], int si, int ei){
    //     // Base case
    //     if(si>=ei){
    //         return;
    //     }
    //     // work
    //     int mid = si + (ei-si)/2;
    //     mergeSort(arr, si, mid);
    //     mergeSort(arr, mid+1, ei);

    //     merge(arr,si,mid,ei);
    // }
    // public static void merge(int arr[],int si, int mid, int ei){
    //     int temp [] = new int[ei-si+1];
    //     int i = si;
    //     int j = mid+1;
    //     int k = 0;
    //     while(i<=mid && j<=ei){
    //         if(arr[i]<arr[j]){
    //             temp[k]=arr[i];
    //             i++;
    //         }else{
    //             temp[k]=arr[j];
    //             j++;
    //         }
    //         k++;
    //     }
    //     //for left over element of 1st sorted part
    //     while(i<=mid){
    //         temp[k++] = arr[i++];
    //     }
    //     //for left over element of 2st sorted part
    //     while(j<=ei){
    //         temp[k++] = arr[j++];
    //     }
    //     for(k=0, i=si; k<temp.length; k++, i++){
    //         arr[i]=temp[k];
    //     }
    // }

    public static void mergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr,mid,si,ei);
    }
    public static void merge(int arr[], int mid, int si, int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        // left 
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        //right
        while(j<=ei){
            temp[k++] = arr[j++];
        }
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i]= temp[k];
        }
    }

    // // Quick sort
    // public static void quickSort(int arr[], int si, int ei){
    //     // base case
    //     if(si>=ei){
    //         return;
    //     }
    //     int pIdx = pviot(arr,si,ei);
    //     quickSort(arr, si, pIdx-1);
    //     quickSort(arr, pIdx+1, ei);
    // }

    // public static int pviot(int arr[],int si,int ei){
    //     int pivot = arr[ei];
    //     int i = si-1;
    //     for(int j=si; j<ei; j++){
    //         if(arr[j]<=pivot){
    //             i++;
    //             // swap
    //             int temp = arr[j];
    //             arr[j] = arr[i];
    //             arr[i] = temp;
    //         }            
    //     }
    //     i++;
    //     // swap
    //     int temp = pivot;
    //     arr[ei] = arr[i];
    //     arr[i] = temp;  

    //     return i;
              
    // }

    public static void quickSort(int arr[],int si, int ei){
        if(si>=ei){
            return;
        }
        int pIdx = partion(arr,si,ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }
    public static int partion(int arr[],int si, int ei){
        int pivot = arr[ei];
        int i = si-1;
        for(int j=si; j<pivot; j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        //swap
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void addSum(int arr[]){
        int evenSum = 0; int oddSum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2==0){
                evenSum+=arr[i];
            }else{
                oddSum+=arr[i];
            }

        }
        System.out.println("even sum is: "+evenSum);
        System.err.println("odd sum is: "+oddSum);
    }

    public static void filterString(String str,String ref){
        String newStr = "";
        for(int i=0; i<str.length(); i++){
            boolean isMatch = false;
            for(int j=0; j<ref.length(); j++){
                if(str.charAt(i)==ref.charAt(j)){
                    isMatch=true;
                    break;
                }
            }
            if(!isMatch){
                newStr+=str.charAt(i);
            }
        }
        System.out.println(newStr);
    }
    public static int maxValue(int arr[], int k){
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<arr.length-k; i++){
            int currentMin = Integer.MAX_VALUE;
            for(int j=i; j<i+k; j++){
                currentMin = Integer.min(currentMin,arr[j]);
            }
            maxValue = Integer.max(maxValue, currentMin);
        }
        return maxValue;
    }

    // search in sorted roated array
    public static int search(int arr[],int target, int si, int ei){
        if(si>ei){
            return -1;
        }

        int mid = si+(ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }

        // L1
        if(arr[si]<=arr[mid]){
            //case a:
            if(target>=arr[si]&&target<=arr[mid]){
                return search(arr, target, si, mid-1);
            }else{
                return search(arr, target, mid+1, ei);
            }
        }else{
            if(target>=arr[mid]&&target<=arr[ei]){
                return search(arr, target, mid+1, ei);
            }else{
                return search(arr, target, si, mid-1);
            }
        }
    }

    public static void main(String args[]){
        int arr[] = {3,1,4,6,2,5};
        // mergeSort(arr,0,arr.length-1);
        // quickSort(arr, 0, arr.length-1);
        // printArray(arr);
        // addSum(arr);
        // String str = "programming";
        // String ref = "grm";
        // filterString(str, ref);
        // System.out.println(maxValue(arr, 2));
        int result = search(arr, 7, 0, arr.length-1);
        System.out.println(result);
    }
}
