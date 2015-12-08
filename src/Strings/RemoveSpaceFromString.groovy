package Utils.Interview.Strings

/**
 * Created by subrahmanyamr on 7/14/2015.
 */
class RemoveSpaceFromString {

    public static void main(String[] args) {
        char[] str = "g  eeks  for ge  eeks "
        removeSpaces(str);
    }

    public static void removeSpaces(char[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                arr[count] = arr[i]
                if (count > 1) {
                    arr[i] = ' ';
                }
                count++;
            }
        }
        println(arr)
    }
}
