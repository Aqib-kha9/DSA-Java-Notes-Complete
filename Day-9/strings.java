import java.util.Arrays;
import java.util.Scanner;

public class strings {

    public static int countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                        count++;
            }
        }
        return count;
    }

    public static boolean isAnagrams(String str1, String str2){
        str1.toLowerCase();
        str2.toLowerCase();
        boolean result = false;
        if(str1.length()==str2.length()){
            char[] str1char = str1.toCharArray();
            char[] str2char = str2.toCharArray();

            Arrays.sort(str1char);
            Arrays.sort(str2char);
            result = Arrays.equals(str1char,str2char);
        }
        return result;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String str = sc.nextLine();
        // System.out.println(countVowels(str));
        // String str = "ShardhaDidi";
        String str1 = "racp";
        String str2 = "care";
        // System.out.println(str.equals(str1)+" "+str.equals(str2));

        // String str = "ApnaCollege".replace("l", "");

        // System.out.println(str);
        System.out.println(isAnagrams(str1, str2));
    }
}
