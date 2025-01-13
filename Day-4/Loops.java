import java.util.*;

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // # Question2: Write a program that reads a set of integers, and then prints
        //  the sum of the even and odd integers 

        int number;
        int choice;
        int evenSum = 0;
        int oddSum = 0;

        do{
            System.out.print("Enter number :");
            number = sc.nextInt();
            if(number%2==0){
                evenSum+=number;
            }else{
                oddSum+=number;
            }
            System.out.print("press any key if you want to continue, if you want to stop then press 1");
            choice = sc.nextInt();
        }while(choice!=1);

        System.out.println("even sum : "+ evenSum);
        System.out.println("odd sum : "+ oddSum);
    }
}
