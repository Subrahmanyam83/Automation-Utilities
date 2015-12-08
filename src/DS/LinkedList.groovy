package Utils.DS

/**
 * Created by subrahmanyamr on 6/14/2015.
 */
class LinkedList {

    public static Node head=null;
    public static Node tail=null;

    public static class Node{
        Node node;
        Object data;


        public Node(){}

        public Node(Object data){
            if(head == null) {
                head = this;
            }
            else {
                tail.node = this;
            }
            this.data = data;
            tail = this;
        }
    }

    public static void main(String[] args){
        insertNodeAtTheEnd(56);
        insertNodeAtTheEnd(23);
        insertNodeAtTheEnd(97);
        insertNodeAtTheEnd(12);
        /*insertNodeAtTheEnd("Subrahmanyam")
        insertNodeAtTheEnd(123456789.123456789)
        printLinkedList();
        insertAfter("RV",97);
        insertAfter("Rentala","RV")
        insertAfter("Chinnu","RV")
        printLinkedList()
        insertBefore("Rakesh","RV")*/
        printLinkedList()
        sortLinkedList();
        printLinkedList()
    }

    /*This Function creates a new node and assigns the parameter data to its data part
    * @param: data value that is assigned to the Node's data*/
    public static sortLinkedList(){
        int key;
        for (Node n = head ; n != null; n = n.node){
            for (Node m = n.node; m != null; m = m.node){
                if (n.data > m.data){
                    key =  m.data;
                    m.data = n.data;
                    n.data = key;
                }
            }
        }
    }

    /*This Function creates a new node and assigns the parameter data to its data part
    * @param: data value that is assigned to the Node's data*/
    public static insertNodeAtTheEnd(Object data){
        new Node(data);
    }

    /*This method will insert a desired data after the given data*/
    public static insertAfter(Object dataToBeAdded, Object dataToBeAddedAfterValue){
        for(Node n = head;n!=null;n=n.node){
            if(n.data.equals(dataToBeAddedAfterValue)){
                Node newNode = new Node();
                newNode.data = dataToBeAdded;
                newNode.node = n.node
                n.node = newNode;
                break;
            }
        }
    }

    /*This method will insert a desired data before the given data*/
    public static insertBefore(Object dataToBeAdded, Object dataToBeAddedBeforeValue){
        for(Node n1 = head;n1!=null;n1=n1.node){
            if(n1.node.data.equals(dataToBeAddedBeforeValue) && (n1.node != null)){
                Node newNode1 = new Node();
                newNode1.data = dataToBeAdded;
                newNode1.node = n1.node
                n1.node = newNode1;
                break;
            }
        }
    }

    /*This function prints the Linked List in a Linear way.*/
    public static printLinkedList(){
        for(Node n=head;n!=null;n=n.node){
            print(n.data+"--")
        }
        println()
    }

    /*This method will delete the given data from the Linked List*/
    public static deleteNode(Object data) {
        for (Node n = head; n != null; n = n.node) {
            if (n.data == data) {
                n.data=n.node.data;
                n.node=n.node.node;
                break;
            }
        }
        //throw "Deleted Data does not exist in the Linked List"
    }
}





























