// import java.util.*;


public class arrays {

    public static boolean containsDubplicate(int[] nums){
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    } 

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        int[] nums = {1,2,3,6};

        boolean value = containsDubplicate(nums);
        System.err.println(value);

        System.out.println(nums[0]);


    }
}
