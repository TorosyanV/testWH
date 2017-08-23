import java.util.Arrays;
import java.util.List;

public class Palindrome {
    public static void main(String args[]) {

        List<String> stringList = Arrays.asList("abba", "XyZ","1221","asXaa","a","bab","121121");
        for (String st : stringList) {
            System.out.println(st + "->" + isPalindrome(st));
        }
    }

    // fastest solution
    public static boolean isPalindrome(String input) {

        int n = input.length();
        for (int i = 0; i < (n / 2); ++i) {
            if (input.charAt(i) != input.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
