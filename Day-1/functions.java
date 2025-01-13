// import java.util.*;

public class functions {

    public static void print() {
        System.out.println("hi bro");
    }

    public static int calculateSum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void swapTwoNumbers(int a, int b) {
        int c;
        c = a;
        a = b;
        b = c;
        System.out.println(a + "and " + b);
    }

    public static int findProduct(int a, int b) {
        int product = a * b;
        return product;
    }

    public static int findFactorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    public static int binomialCoefficient(int n, int r) {
        int n_fact = findFactorial(n);
        int r_fact = findFactorial(r);
        int nmr_fact = findFactorial(n - r);
        int BC = n_fact / (r_fact * nmr_fact);
        return BC;
    }
    // public static boolean isPrime(int n){
    // boolean isPrime = true;
    // for(int i=2; i<=n-1; i++){
    // if(n%i==0){
    // isPrime=false;
    // break;
    // }
    // }
    // return isPrime;
    // }

    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primesInRange(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void binToDec(int binNum) {

        int pow = 0;
        int decNum = 0;
        while (binNum > 0) {
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));
            pow++;
            binNum = binNum / 10;
        }
        System.out.println(decNum);
    }

    public static void decToBin(int decNum) {
        int pow = 0;
        int binNum = 0;
        while (decNum > 0) {
            int rem = decNum % 2;
            binNum = binNum + (rem * (int) Math.pow(10, pow));
            pow++;
            decNum = decNum / 2;
        }
        System.out.println(binNum);
    }

    public static double avgThreeNum(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome(int num) {
        int duplicate = num;
        int reverse = 0;
        while (num > 0) {
            int rem = num % 10;
            reverse = rem + (reverse * 10);
            num = num / 10;
        }
        return (reverse == duplicate);
    }

    public static int sumOfDigit(int num) {
        int sumOfDigits = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sumOfDigits += lastDigit;
            num = num / 10;
        }
        return sumOfDigits;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // int num = sc.nextInt();
        int num = 12;
        int TotalSum = sumOfDigit(num);
        System.out.println(TotalSum);
    }

}