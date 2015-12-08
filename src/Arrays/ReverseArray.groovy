package Utils.Interview.Arrays

/**
 * Created by subrahmanyamr on 7/20/2015.
 */
class ReverseArray {

    public static void main(String[] args){
        String a = "Hi I am Subrahmanyam";
        char[] arr = a.toCharArray();
        println(4%2)
        printArray(arr);
        reverseString(arr);
    }

    public static void reverseString(char[] arr) {
        int mid,temp;
        int size = arr.length
        mid = (size % 2 ==0)?size/2:(size/2)+1;
        for(int i in 0..mid){
            temp=arr[size-1];
            arr[size-1]=arr[i];
            arr[i]=temp;
            size--;
        }
        for(int j in 0..arr.length-1){
            print(arr[j])
        }
        println();
    }

    public static void printArray(char[] arr) {
        for(int j in 0..arr.length-1){
            print(arr[j])
        }
        println();
    }
}
