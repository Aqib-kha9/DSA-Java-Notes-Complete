public class functions {

    public static int average(int num1, int num2, int num3){
        int avr = (num1+num2+num3)/3;
        return avr;
    }

    public static boolean isEven(int num){
        if(num%2==0){
            return true;
        }
        return false;
    }
    public static int revNum(int num){
        int rev=0;
        int rem;
        while (num>0) {
            rem = num%10;
            rev = rev*10+rem;
            num = num/10;
        }
        return rev;
    }
    public static boolean isPalindrome(int num){
        int rev = revNum(num);
        if(rev==num){
            return true;
        }
        return false;
    }
    public static int sumOfDigit(int num){
        int sum = 0;
        while(num>0){
            int lastDigit = num%10;
            sum = sum+lastDigit;
            num = num/10;
        }
        return sum;
    }


    public static void main(String[] args){
        System.out.println(sumOfDigit(234));
    }
}
