package Utils.DS

/**
 * Created by subrahmanyamr on 7/1/2015.
 */
class QueueList {

    public static Node front = null;
    public static Node rear = null;
    public static Node previous = null;

    public static class Node{
        Object data;
        Node next;

        public Node(data){
            if(rear == null){
                rear = this;
                front = this;
            }
            else{
                this.next = front;
                front = this;
                previous = this.next;
            }
            this.data = data;
        }
    }

    public static void main(String[] args){
        enQueue(15);
        enQueue(30);
        enQueue(45);
        printQueueList();
        deQueue();
        println();
        printQueueList();
    }

    public static void enQueue(Object data){
        new Node(data);
    }

    public static void deQueue(){
        Node n = front;
        while(n.next != rear){
            n = n.next;
        }
        rear = n;
        rear.next = null;
    }

    public static void printQueueList(){
        for(Node n = front; n!=null;n=n.next){
            println(n.data+"-");
        }
    }
}
