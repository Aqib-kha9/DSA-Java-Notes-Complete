public class bitWiseOpe {

    // Swap two numbers without using any third variable
    public static void swapTwoNum(int a, int b) {
        System.out.println("Before swapping:");
        System.out.println("a = " + a + ", b = " + b);

        // Swapping using XOR
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After swapping:");
        System.out.println("a = " + a + ", b = " + b);
    }

    // Add 1 to an integer using Bit Manipulation.
    public static int addone(int n) {
        int result = -(~n);
        return result;
    }

   //Convert uppercase characters to lowercase using bits.

    public static void uprCaseToLowCase(){
        for(char ch ='A'; ch<='Z'; ch++ ){
            System.out.print((char)(ch | ' '));
        }
    }

    public static void main(String[] args) {
        // swapTwoNum(5, 7);
        // System.out.println(addone(8));
        uprCaseToLowCase();
    }
}
