package Utils.Interview.Strings

/**
 * Created by subrahmanyamr on 7/8/2015.
 */
class Arrange_0_1_2 {

    public static void main(String[] args) {
        int[] arr = [1,2,1,0,0,0,2,2,1,1,2];
        int arr_size = arr.size();
        int a = 2;
        int b = 3;
        swap(a,b);
        println(a+"--"+b)

        /*println(arr_size)
        sort012(arr, arr_size);
        println("array after segregation ");
        printArray(arr, arr_size);*/

    }

    static void printArray(int[] arr,int arr_size){
        for(int i =0;i<arr_size;i++){
            print(arr[i]+"--")
        }
    }

    static void swap(int a,int b){
        int temp;
        temp=a;
        a=b;
        b=temp;
    }

    static void sort012(int[] a, int arr_size)
    {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0;

        while (mid <= hi)
        {
            switch (a[mid])
            {
                case 0:
                    swap(a[lo++], a[mid++]);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(a[mid], a[hi--]);
                    break;
            }
        }
    }
}
