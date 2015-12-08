package Utils.Interview.Arrays

import java.lang.reflect.Array

/**
 * Created by subrahmanyamr on 7/20/2015.
 */
class SearchElementInPivotedArray {

    public static void main(String[] args) {
        Array[] arr = [7,18,29,1,2,3,4,5,16]
        searchAnElement(arr)
    }

    public static void searchAnElement(Array[] arr) {
        int mid;
        int size = arr.length
        mid = (size%2 ==0)?size/2:(size/2)+1;

    }
}
