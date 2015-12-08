package Utils.Interview.Arrays

/**
 * Created by subrahmanyamr on 7/16/2015.
 */
class UnionAndIntersection {

    public static List arrIntersection = []

    public static void main(String[] args) {
        int[] arr1 = [1, 2, 3, 5, 7, 9, 11]
        int[] arr2 = [2, 6, 9, 7, 10, 11]
        int i = 0, j = 0;
        //union()
        intersection(arr1, arr2, i, j)
        println(arrIntersection)
    }

    public static void intersection(int[] arr1, int[] arr2, int i, int j) {
        if (i == (arr1.length - 1)) {
            while (j < arr2.length) {
                if (arr1[i] == arr2[j]) {
                    arrIntersection.add(arr1[i])
                }
                j++;
            }
        } else if (j == (arr2.length - 1)) {
            while (i < arr1.length) {
                if (arr1[i] == arr2[j]) {
                    arrIntersection.add(arr1[j])
                }
                i++;
            }
        } else if (arr1[i] < arr2[j]) {
            if (!(i == (arr1.length - 1))) {
                i++;
                intersection(arr1, arr2, i, j);
            }

        } else if (arr1[i] > arr2[j]) {
            if (!(j == (arr2.length - 1))) {
                j++;
                intersection(arr1, arr2, i, j);
            }
        } else if (arr1[i] == arr2[j]) {
            if ((!(i == (arr1.length - 1))) && (!(j == (arr2.length - 1)))) {
                arrIntersection.add(arr1[i]);
                i++;
                j++;
                intersection(arr1, arr2, i, j);
            }
        }
    }
}