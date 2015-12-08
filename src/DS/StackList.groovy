package Utils.DS

/**
 * Created by subrahmanayamv on 1/7/15.
 */
class StackList {

    public static int size = 0;
    public static int maxSize = 10;
    public static Node head = null;
    public static Node tail = null;

    public static class Node{
        Node next;
        Object data;

        public Node(Object data){
            if(head==null){
                head = this;
                tail = this;
                this.data = data;
                this.next = null;
            }
            else{
                this.data = data;
                this.next = head;
                head = this;
            }
        }
    }

    public static void main(String[] args){
        for (int i = 0; i <= 11; i++){
            push(15);
        }
        println(size)
        printStackElements()
        println()
        pop()
        pop()
        pop()
        printStackElements()
    }

    public static push(Object data){
        if(size >= maxSize){
            println("STACK OVERFLOW");
        }
        else {
            new Node(data);
            size++;
        }
    }

    public static pop(){
        if(head == null){
            println("STACK UNDERFLOW");
        }
        else{
            head = head.next;
            size--;
        }
    }

    public static printStackElements(){
        for(Node n = head; n !=null; n=n.next){
            println(n.data+"-----");
        }
    }
}
