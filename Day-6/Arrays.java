import java.util.Scanner;

public class Arrays {

    public static void SubArray(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(numbers[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Brute Force O(n3)
    public static void subArraySum(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += numbers[k];
                }
                System.out.println(currSum);
            }
            if (maxSum < currSum) {
                maxSum = currSum;
            }

        }
        System.out.println("max sum = " + maxSum);
    }

    // Prefix O(n2)
    public static void prifixSubASum(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int Prefix[] = new int[numbers.length];
        Prefix[0] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            Prefix[i] = Prefix[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                currSum = i == 0 ? Prefix[j] : Prefix[j] - Prefix[i - 1];
            }
            if (maxSum < currSum) {
                maxSum = currSum;
            }
        }
        System.out.println("max Sum = " + maxSum);
    }
    // using kadanes algorithm O(n)

    public static void kadanes(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            currSum += numbers[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = { -2, -3, -2, -3, -6 };
        kadanes(numbers);
    }

}
