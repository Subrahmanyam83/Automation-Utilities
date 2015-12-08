package Utils.Interview.Arrays

/**
 * Created by subrahmanyamr on 6/26/2015.
 */
/*An array of numbers is give. Write algorithm to divide this array in two subarrays such that difference of sum between these subarrays is minimum*/
public class SubArraySumDifferenceZero {

    public static void main(String[] args){
        Integer[] arr = [1,3,4,7,9,17];
        Integer sum = (arr.sum())/2;
        println(sum)
        println(differenceBetweenSubArraysIsMinimum(arr,arr.length,sum));
    }

    public static boolean differenceBetweenSubArraysIsMinimum(Integer[] arr, Integer n , Integer sum){
        /*Arrays.sort(arr);
        System.out.println(arr);
        println(arr.sum()/2)*/

        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (arr[n-1] > sum)
            return differenceBetweenSubArraysIsMinimum (arr, n-1, sum);

        /* else, check if sum can be obtained by any of the following
           (a) including the last element
           (b) excluding the last element
        */
        return differenceBetweenSubArraysIsMinimum (arr, n-1, sum) || differenceBetweenSubArraysIsMinimum (arr, n-1, sum-arr[n-1]);
    }
}
