package Utils.Interview.Tree

/**
 * Created by subrahmanyamr on 6/26/2015.
 */
class Tree1 {

    static Node rootnode;
    public static int x = 2;

    public static class Node {

        Node left;
        Node right;
        Node parent;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
    static def arr = new Integer[20];
    static int i =0;


    public static void main(String[] args) {
        rootnode = new Node(25);
        System.out.println("Building tree with root value " + rootnode.value);
        System.out.println("=================================");

        insert(rootnode, 11);
        insert(rootnode, 34);
        insert(rootnode, 6);
        insert(rootnode, 79);
        insert(rootnode, 80);
        insert(rootnode, 17);
        insert(rootnode, 9);
        insert(rootnode, 18);
        insert(rootnode, 19);
        insert(rootnode, 72);
        insert(rootnode, 12);

        /*printZigZag(rootnode);
        InorderDisplay(rootnode);
        mirrorImageOfATree(rootnode);
        InorderDisplay(rootnode);*/
        /*Longest nodes between two nodes*/
        //println 1 + diameterOfTree(rootnode.left.right.left) + diameterOfTree(rootnode.left.right.right)
        //sumFromRootToNode(rootnode,62,0)
        //commonParent(rootnode,12,19)
        //rootToLeafPaths(rootnode,arr,0)
        maximumWidthOfTree(rootnode,0)
        println(arr)
        }

    public static void maximumWidthOfTree(Node node,int i ) {
        if(node!=null){
            if(arr[i]==null){
                arr[i] = 1;
            }
            else{
                arr[i] = arr[i]+1;
            }
            i++;
        }
        if(node.left!=null){
            maximumWidthOfTree(node.left,i)
        }
        if(node.right!=null){
            maximumWidthOfTree(node.right,i)
        }
    }

    public static void rootToLeafPaths(Node node, Integer[] arr, int length) {
        if(node==null)
            return;

        arr[length]=node.value;
        length++;

        if(node.left==null && node.right==null){
            printArray(arr,length)
        }
        else {
            rootToLeafPaths(node.left, arr,length)
            rootToLeafPaths(node.right, arr,length)
        }
    }

    public static void printArray(Integer[] arr, int len) {
        for(int i=0;i<len;i++){
            print(arr[i]+"--")
        }
        println()
    }

    public static commonParent(Node node, int a, int b){
       int level1 = findHeight(rootnode,a,0).get("level")
       Node node1 = findHeight(rootnode,a,0).get("node")
       int level2 = findHeight(rootnode,b,0).get("level")
       Node node2 = findHeight(rootnode,b,0).get("node")

        if(level1>level2){
            for(int i in 0..(level1-level2-1)){
                node1 = node1.parent;
            }
        }
        else if(level2>level1){
            for(int i in 0..(level2-level1-1)){
                node2 = node2.parent;
            }
        }

        while(node1.parent.value!=node2.parent.value){
            node1=node1.parent;
            node2=node2.parent;
        }
        println(node1.parent.value)

    }

    public static Map findHeight(Node node, int val, int level){
        if (node.value == val){
            Map map = new HashMap()
            map.put("level",level);
            map.put("node",node);
            return map;
        }
        else if (node.left != null && val <= node.value){
            findHeight(node.left,val,level+1)
        }
        else if (node.right != null && val >= node.value){
            findHeight(node.right,val,level+1)
        }
    }

    public static void sumFromRootToNode(Node node, int sum,int level) {
        if((node.left == null) && (node.right == null) ){
            if(sum==(level+node.value))
            {
                println("Yes")
            }
        }
        if(node.left!=null){
            sumFromRootToNode(node.left,sum,level+node.value);
        }
        if(node.right!=null){
            sumFromRootToNode(node.right,sum,level+node.value);
        }
    }

    public static int diameterOfTree(Node node) {
        if (node == null){
            return 0
        }
        else {
            return 1+ Math.max(diameterOfTree(node.left),diameterOfTree(node.right))
        }
    }

    public static void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of Node " + node.value);
                node.left = new Node(value);
                node.left.parent = node;
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of Node " + node.value);
                node.right = new Node(value);
                node.right.parent = node;
            }
        }
    }

    public static void InorderDisplay(Node node) {
        if (node.left != null) {
            InorderDisplay(node.left);
        }
        System.out.print(node.value + "-");

        if (node.right != null) {
            InorderDisplay(node.right);
        }
    }

    public static void printZigZag(Node node) {
        Queue q = new LinkedList();
        Stack s = new LinkedList();
        q.offer(node);

        while (!(q.isEmpty()) || !(s.isEmpty())) {
            ArrayList arr = [];
            while (!(q.isEmpty())) {
                arr.add(q.poll())
            }
            if (x % 2 == 0) {
                for (int j = 0; j < arr.size(); j++) {
                    System.out.print(arr[j].value + "-");

                }
            } else {
                for (int m = arr.size() - 1; m >= 0; m--) {
                    System.out.print(arr[m].value + "-");
                }
            }
            for (int j = 0; j < arr.size(); j++) {
                if (arr[j].left != null)
                    q.offer(arr[j].left);
                if (arr[j].right != null)
                    q.offer(arr[j].right);

            }
            x++;
        }
    }

    public static void mirrorImageOfATree(Node node) {
        Node temp;

        if (node == null) {
            return;
        } else {
            temp = node.left;
            node.left = node.right;
            node.right = temp;

            mirrorImageOfATree(node.left);
            mirrorImageOfATree(node.right);
        }
    }
}