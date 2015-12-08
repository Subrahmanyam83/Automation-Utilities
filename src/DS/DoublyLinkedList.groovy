package Utils.DS

/**
 * Created by subrahmanyamr on 6/22/2015.
 */
class DoublyLinkedList {

    public static Node head = null;
    public static Node tail = null;

    public static class Node {

        Object data;
        Node left;
        Node right;

        Node() {}

        Node(Object data) {
            if (head == null) {
                head = this;
                this.left = null;
                this.right = null;
                this.data = data;
                tail = this;
            } else {
                tail.right = this;
                this.data = data;
                this.left = tail;
                this.right = null;
                tail = this;
            }
        }
    }

    public static void main(String[] args) {
        insertNodeAtTheEnd("First");
        insertNodeAtTheEnd("Third");
        insertNodeAtTheEnd("Second");
        printLinkedList();
    }

    public static insertNodeAtTheEnd(Object data) {
        new Node(data)
    }

    public static printLinkedList(){
        for (Node n = head; n != null;n = n.right){
            println("Value:----"+n.data+"----Previous: "+n.left.data+"-----Next: "+n.right.data)
        }

    }
}
