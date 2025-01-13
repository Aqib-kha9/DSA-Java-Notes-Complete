public class sortings {

    public static void bubbleSort(int nums[]){
        for(int turn=0; turn<nums.length-1; turn++){
            for(int j=0; j<nums.length-1-turn; j++){
                if(nums[j]<nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public static void selectionSort(int nums[]){
        for(int i=0; i<nums.length-1; i++){
            int minPos = i;
            for(int j=i+1; j<nums.length; j++){
                if(nums[minPos]<nums[j]){
                    minPos = j;
                }

            }
            int temp = nums[minPos];
            nums[minPos] = nums[i];
            nums[i] = temp;
        }
    }

    public static void printArr(int nums[]){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        int nums[] = {3,6,2,1,8,7,4,5,3,1};
        selectionSort(nums);
        printArr(nums);
    }
}
