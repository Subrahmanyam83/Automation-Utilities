package Utils.DS

/**
 * Created by subrahmanyamr on 7/1/2015.
 */
class QueueArray {
    public static Object queuearr;
    public static int numberOfElementsPresent = 0;

    public QueueArray(int size){
        queuearr = new Object[size];
    }

    public static void main(String[] args){
        new QueueArray(10);
        enqueue(15);
        enqueue(30);
        enqueue(45);
        enqueue(60);
        println(queuearr);
        println();
        dequeue();
        dequeue();
        enqueue(90);
        enqueue(105);
        println(queuearr);
    }

    public static void enqueue(Object data){
        if(numberOfElementsPresent==10){
            println("ARRAY FULL. CANNOT INSERT MORE VALUE. INCREASE THE SIZE OF THE ARRAY DUDEEEEE !!!");
        }
        else{
            queuearr[numberOfElementsPresent] = data;
            numberOfElementsPresent++;
        }
    }

    public static void dequeue(){
        if(numberOfElementsPresent==0){
            println("ARRAY EMPTY. INSERT VALUES BEFORE REMOVING")
        }
        for (int i = 0; queuearr[i]!=null;i++){
            queuearr[i] = queuearr[i+1];
        }
        numberOfElementsPresent--;
    }

}
