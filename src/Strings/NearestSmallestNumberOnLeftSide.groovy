package Utils.Interview.Strings

/**
 * Created by subrahmanyamr on 7/15/2015.
 */
class NearestSmallestNumberOnLeftSide {

    public static HashMap map = new HashMap();
    public static void main(String[] args) {
        int[] arr = [1, 6, 4, 10, 2, 5]
        nearestNumber(arr);
    }

    public static void nearestNumber(int[] arr) {
        Stack<Integer> stack = new LinkedList<Integer>()
        stack.push(-1)
        for (int i = 0;i<arr.length;i++){
            if(stack.peek() < arr[i]){
                map.put(arr[i],stack.peek());
            }
            else{
                while(stack.peek() > arr[i]){
                    stack.pop();
                }
                map.put(arr[i],stack.peek());
            }
            stack.push(arr[i])
        }
        println(map)
    }
}
