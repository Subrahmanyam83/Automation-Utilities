package test.groovy.Utils.Interview.Arrays

/**
 * Created by subrahmanyamr on 11/15/2015.
 */
class MergeTwoSortedArrays {

    public static int[] arr1 = [1,3,5,-1,-1,-1,-1];
    public static int[] arr2 = [2,4,6,7];
    public static void main(String[] args) {

        arr1[0]=1;
        arr1[1]=3;
        arr1[2]=5;
        arr2[0]=2;
        arr2[1]=4;
        arr2[2]=6;
        arr2[3]=7;

        int i=0;
        int j=0;
        println(arr1);
        println(arr2);

        while(i<7){
            if((arr1[i] < arr2[j]) && (arr2[j]) <arr1[i+1]){
                moveAndSwap(j,i+1);
                j++;
            }

            if(arr1[i] < arr2[j]){
                if((arr1[i+1])!= -1 && arr1[i+1] < arr2[j])
                {i++;}
                else if(arr1[i+1]==-1){
                    arr1[i+1]=arr2[j];
                    i++;j++;
                }
            }

            if(j==3){
                arr1[i]=arr2[j];
            }

            if(arr1[i] > arr2[j]){
                moveAndSwap(j,i);
                j++;
            }
        }
        print(arr1)
    }

    public static void moveAndSwap(int y, int x){
            for(int a=5;a>=x;a--){
                arr1[a+1]=arr1[a];
            }
            arr1[x]=arr2[y];
        }

}
