package Utils.DS

/**
 * Created by subrahmanayamv on 1/6/15.
 */
public class StackArray {

    public static Object array;

    public StackArray(int size) {
        array = new Object[size];
    }

    private static void push(Object element) {
        if (sizeLeft().equals(0)){
            println("ArrayStack is Full")
        }
        else {
            array[getArraySize()-sizeLeft()] = element
        }
    }

    private static void pop() {
        for (int i=(getArraySize()-1);i>=0;i--){
            if(array[i]!=null){
                array[i]=null;
                return;
            }
        }
    }

    private static purge(){
        for (int i=0;i<getArraySize();i++){
            array[i]=null;
        }
    }

    private static Object getTop() {
        return array[arraySize-sizeLeft()-1]
    }

    private static Integer getArraySize() {
        return array.size();
    }

    private static Integer sizeLeft(){
        for (int i=0;i<getArraySize();i++){
           if(array[i].equals(null)){
               return (getArraySize()-(i))
           }
        }
        return 0;
    }

    private static void printStackArray(){
        println("ARRAYSTACK")
        for (int i=getArraySize()-1;i>=0;i--){
            println("|"+array[i]+"|")
        }
        println()
    }

    public static void main(String[] args) {
        new StackArray(7);
        push(5);
        push(15);
        push(10);
        push(25);
        pop()
        push(3)
        printStackArray()
        purge()
        printStackArray()
        print("Top Element is: "+getTop())
    }
}
