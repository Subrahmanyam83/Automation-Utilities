package Utils.Interview.Arrays

/**
 * Created by subrahmanyamr on 7/13/2015.
 */
class SearchNumberWhichIsNotDuplicatedInArray {

    static Integer mid;
    public static void main(String[] args) {
        def arr = [1,1,2,2,3,3,4,5,5].toArray()
        int low = 0;
        int high = arr.length;
        SearchNumberWhichIsNotDuplicatedInArrayFunction(arr,low,high);
    }

    public static void SearchNumberWhichIsNotDuplicatedInArrayFunction(def arr, def low, def high) {
        mid = ((high-low)/2);
        if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
            println(arr[mid]);
        }
        else if(arr[mid]==arr[mid+1]){
            SearchNumberWhichIsNotDuplicatedInArrayFunction(Arrays.copyOfRange(arr, mid, high),mid,high);
        }
        else if(arr[mid] == arr[mid-1]){
            SearchNumberWhichIsNotDuplicatedInArrayFunction(Arrays.copyOfRange(arr, low, mid),low,mid);
        }
    }
}
