package Utils.Interview.Strings

/**
 * Created by subrahmanyamr on 7/15/2015.
 */
class DivideArrayIntoTwoEqualArrays {

    public static void main(String[] args) {
        int[] arr = [1,3,4,6,2,11];
        divideArrays(arr)
    }

    public static void divideArrays(int[] arr){
        sum(arr)
    }

    public static void sum(arr){
        int s=0;
        for (int i in 0..arr.length-1){
            s=s+arr[i]
        }
        println(s%2==0)
    }
}
