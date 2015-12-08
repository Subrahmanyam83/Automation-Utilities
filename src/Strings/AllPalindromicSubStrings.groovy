package Utils.Interview.Strings

/**
 * Created by subrahmanyamr on 7/7/2015.
 */
class AllPalindromicSubStrings {

    public static void main(String[] args) {
        String a = "ABCBCACBC";
        println("ALL THE PALINDROMIC SUBSTRINGS IN THE STRING "+a+" ARE:")
        printPalindromeStrings(a);
    }

    public static void printPalindromeStrings(String string){
        for (int i = 0;i<string.length() - 1;i++){
            for (int j = i+2; j<string.length();j++){
                isPalindrome(string.substring(i,j));
            }
        }
    }

    public static void isPalindrome(String substring) {
        if(substring.reverse().equals(substring)){
            println(substring);
        }
    }
}
